package cn.nukkit.blockstate;

import cn.nukkit.Server;
import cn.nukkit.api.DeprecationDetails;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.blockproperty.exception.BlockPropertyNotFoundException;
import cn.nukkit.blockstate.exception.InvalidBlockStateException;
import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.Tag;
import cn.nukkit.utils.BinaryStream;
import cn.nukkit.utils.HumanStringComparator;
import com.google.common.base.Preconditions;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
@UtilityClass
@ParametersAreNonnullByDefault
@Log4j2
public class BlockStateRegistry {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public final int BIG_META_MASK = 0xFFFFFFFF;
    private final ExecutorService asyncStateRemover = Executors.newSingleThreadExecutor();

    private final Registration updateBlockRegistration;

    private final Map<BlockState, Registration> blockStateRegistration = new ConcurrentHashMap<>();
    private final Map<String, Registration> stateIdRegistration = new ConcurrentHashMap<>();
    private final Int2ObjectMap<Registration> runtimeIdRegistration = new Int2ObjectOpenHashMap<>();

    private final Map<BlockID, CompoundTag> blockIdToDefaultNBT = new HashMap<>();

    private final Int2ObjectMap<CompoundTag> runtimeIdStatesMap = new Int2ObjectOpenHashMap<>();


    private final byte[] blockPaletteBytes;

    private final List<String> knownStateIds = new ObjectArrayList<>();

    //<editor-fold desc="static initialization" defaultstate="collapsed">
    static {
        //<editor-fold desc="Loading canonical_block_states.nbt" defaultstate="collapsed">
        List<CompoundTag> tags = new ArrayList<>();
        try (InputStream stream = Server.class.getClassLoader().getResourceAsStream("block_palette.nbt")) {
            if (stream == null) {
                throw new AssertionError("Unable to locate block state nbt");
            }

            try (BufferedInputStream bis = new BufferedInputStream(stream)) {
                int runtimeId = 0;
                while (bis.available() > 0) {
                    CompoundTag tag = NBTIO.read(bis, ByteOrder.BIG_ENDIAN, true);

                    int n = runtimeId++;

                    runtimeIdStatesMap.put(n, tag);

                    final String name = tag.getString("name");

                    tag.putInt("runtimeId", n);
                    tag.putString("blockId", name);
                    tags.add(tag);
                    blockIdToDefaultNBT.putIfAbsent(BlockID.byIdentifier(name), tag);
                    knownStateIds.add(getStateId(tag));
                }
            }
        } catch (IOException e) {
            throw new AssertionError(e);
        }
        //</editor-fold>
        Integer infoUpdateRuntimeId = null;

        for (CompoundTag state : tags) {
            BlockID blockId = BlockID.byIdentifier(state.getString("blockId"));
            int runtimeId = state.getInt("runtimeId");
            String name = state.getString("name").toLowerCase();
            if (name.equals("minecraft:unknown")) {
                infoUpdateRuntimeId = runtimeId;
            }

            // Special condition: minecraft:wood maps 3 blocks, minecraft:wood, minecraft:log and minecraft:log2
            // All other cases, register the name normally
            registerStateId(state, runtimeId);
        }

        if (infoUpdateRuntimeId == null) {
            throw new IllegalStateException("Could not find the minecraft:info_update runtime id!");
        }

        updateBlockRegistration = findRegistrationByRuntimeId(infoUpdateRuntimeId);

        try {
            blockPaletteBytes = NBTIO.write(tags, ByteOrder.LITTLE_ENDIAN, true);
        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }

    }
    //</editor-fold>

    @Nonnull
    private String getStateId(CompoundTag block) {
        Map<String, String> propertyMap = new TreeMap<>(HumanStringComparator.getInstance());
        for (Tag tag : block.getCompound("states").getAllTags()) {
            propertyMap.put(tag.getName(), tag.parseValue().toString());
        }

        String blockName = block.getString("name").toLowerCase(Locale.ENGLISH);
        Preconditions.checkArgument(!blockName.isEmpty(), "Couldn't find the block name!");
        StringBuilder stateId = new StringBuilder(blockName);
        propertyMap.forEach((name, value) -> stateId.append(';').append(name).append('=').append(value));
        return stateId.toString();
    }

    @Nullable
    private static Registration findRegistrationByRuntimeId(int runtimeId) {
        return runtimeIdRegistration.get(runtimeId);
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    @Nullable
    public String getKnownBlockStateIdByRuntimeId(int runtimeId) {
        if (runtimeId >= 0 && runtimeId < knownStateIds.size()) {
            return knownStateIds.get(runtimeId);
        }
        return null;
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public int getKnownRuntimeIdByBlockStateId(String stateId) {
        for (String knownStateId : BlockStateRegistry.knownStateIds) {
            if (knownStateId.contains(";") ? knownStateId.split(";")[0].equalsIgnoreCase(stateId) : knownStateId.equals(stateId)) {
                return BlockStateRegistry.knownStateIds.indexOf(knownStateId);
            }
        }

        int result = knownStateIds.indexOf(stateId);
        if (result != -1) {
            return result;
        }
        BlockState state;
        try {
            state = BlockState.of(stateId);
        } catch (NoSuchElementException | IllegalStateException | IllegalArgumentException ignored) {
            return -1;
        }
        String fullStateId = state.getStateId();
        return knownStateIds.indexOf(fullStateId);
    }

    /**
     * @return {@code null} if the runtime id does not matches any known block state.
     */
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nullable
    public BlockState getBlockStateByRuntimeId(int runtimeId) {
        Registration registration = findRegistrationByRuntimeId(runtimeId);
        if (registration == null) {
            return null;
        }
        BlockState state = registration.state;
        if (state != null) {
            return state;
        }
        CompoundTag originalBlock = registration.originalBlock;
        if (originalBlock != null) {
            state = buildStateFromCompound(originalBlock);
            if (state != null) {
                registration.state = state;
                registration.originalBlock = null;
            }
        }
        return state;
    }

    @Nullable
    private BlockState buildStateFromCompound(CompoundTag block) {
        String name = block.getString("name").toLowerCase(Locale.ENGLISH);
        BlockID id = getBlockId(name);
        if (id == null) {
            return null;
        }

        BlockState state = BlockState.of(id);

        CompoundTag properties = block.getCompound("states");
        for (Tag tag : properties.getAllTags()) {
            state = state.withProperty(tag.getName(), tag.parseValue().toString());
        }

        return state;
    }

    private static NoSuchElementException runtimeIdNotRegistered(int runtimeId) {
        return new NoSuchElementException("The block id for the runtime id " + runtimeId + " is not registered");
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public BlockID getBlockIdByRuntimeId(int runtimeId) {
        Registration registration = findRegistrationByRuntimeId(runtimeId);
        if (registration == null) {
            throw runtimeIdNotRegistered(runtimeId);
        }
        BlockState state = registration.state;
        if (state != null) {
            return state.getBlockId();
        }
        CompoundTag originalBlock = registration.originalBlock;
        if (originalBlock == null) {
            throw runtimeIdNotRegistered(runtimeId);
        }
        try {
            state = buildStateFromCompound(originalBlock);
        } catch (BlockPropertyNotFoundException e) {
            String name = originalBlock.getString("name").toLowerCase(Locale.ENGLISH);
            BlockID id = getBlockId(name);
            if (id == null) {
                throw runtimeIdNotRegistered(runtimeId);
            }
            return id;
        }
        if (state != null) {
            registration.state = state;
            registration.originalBlock = null;
        } else {
            throw runtimeIdNotRegistered(runtimeId);
        }
        return state.getBlockId();
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public int getRuntimeId(BlockState state) {
        if (state.getStateId().equals("minecraft:coral") || state.getStateId().equals("minecraft:coral_block")) { // TODO: Kaooot
            return getRegistration(BlockState.of(BlockID.AIR)).runtimeId;
        }

        return getRegistration(convertToNewState(state)).runtimeId;
    }

    private BlockState convertToNewState(BlockState oldState) {
        // Check OldWoodBarkUpdater.java and https://minecraft.fandom.com/wiki/Log#Metadata
        // The Only bark variant is replaced in the client side to minecraft:wood with the same wood type
        if (oldState.getBitSize() == 4 && (oldState.getBlockId() == BlockID.LOG || oldState.getBlockId() == BlockID.LOG2)) {
            int exactInt = oldState.getExactIntStorage();
            if ((exactInt & 0b1100) == 0b1100) {
                int increment = oldState.getBlockId() == BlockID.LOG ? 0b000 : 0b100;
                return BlockState.of(BlockID.LOG, (exactInt & 0b11) + increment);
            }
        }
        return oldState;
    }

    private Registration getRegistration(BlockState state) {
        return blockStateRegistration.computeIfAbsent(state, BlockStateRegistry::findRegistration);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public int getRuntimeId(BlockID blockId) {
        return getRuntimeId(BlockState.of(blockId));
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Deprecated
    @DeprecationDetails(reason = "The meta is limited to 32 bits", replaceWith = "getRuntimeId(BlockState state)", since = "1.3.0.0-PN")
    public int getRuntimeId(BlockID blockId, int meta) {
        return getRuntimeId(BlockState.of(blockId, meta));
    }

    public int getRuntimeIdByStates(CompoundTag compoundTag) {
        for (Map.Entry<Integer, CompoundTag> entry : runtimeIdStatesMap.entrySet()) {
            if (entry.getValue().getString("name").equalsIgnoreCase(compoundTag.getString("name")) &&
                    entry.getValue().getCompound("states").equals(compoundTag.getCompound("states"))) {
                return entry.getKey();
            }
        }

        return 0;
    }

    private Registration findRegistration(final BlockState state) {
        // Special case for PN-96 PowerNukkit#210 where the world contains blocks like 0:13, 0:7, etc
        if (state.getBlockId() == BlockID.AIR) {
            Registration airRegistration = blockStateRegistration.get(BlockState.AIR);
            if (airRegistration != null) {
                return new Registration(state, airRegistration.runtimeId, null);
            }
        }

        Registration registration = findRegistrationByStateId(state);
        removeStateIdsAsync(registration);
        return registration;
    }

    private Registration findRegistrationByStateId(BlockState state) {
        Registration registration = null;
        try {
            registration = stateIdRegistration.remove(state.getStateId());

            if (registration != null) {
                registration.state = state;
                registration.originalBlock = null;
                return registration;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            registration = stateIdRegistration.remove(state.getLegacyStateId());

            if (registration != null) {
                registration.state = state;
                registration.originalBlock = null;
                return registration;
            }
        } catch (Exception e) {
            log.fatal("An error has occurred while trying to parse the legacyStateId of {}:{}", state.getBlockId(), state.getDataStorage(), e);
        }

        return null;
    }

    private void removeStateIdsAsync(@Nullable Registration registration) {
        if (registration != null && registration != updateBlockRegistration) {
            asyncStateRemover.submit(() -> stateIdRegistration.values().removeIf(r -> r.runtimeId == registration.runtimeId));
        }
    }

    private void registerStateId(CompoundTag block, int runtimeId) {
        String stateId = getStateId(block);
        Registration registration = new Registration(null, runtimeId, block);

        Registration old = stateIdRegistration.putIfAbsent(stateId, registration);
        if (old != null && !old.equals(registration)) {
            throw new UnsupportedOperationException("The persistence NBT registration tried to replaced a runtime id. Old:" + old + ", New:" + runtimeId + ", State:" + stateId);
        }

        runtimeIdRegistration.put(runtimeId, registration);
    }

    private void registerState(BlockID blockId, int meta, CompoundTag originalState, int runtimeId) {
        BlockState state = BlockState.of(blockId, meta);
        Registration registration = new Registration(state, runtimeId, null);

        Registration old = blockStateRegistration.putIfAbsent(state, registration);
        if (old != null && !registration.equals(old)) {
            throw new UnsupportedOperationException("The persistence NBT registration tried to replaced a runtime id. Old:" + old + ", New:" + runtimeId + ", State:" + state);
        }
        runtimeIdRegistration.put(runtimeId, registration);

        stateIdRegistration.remove(getStateId(originalState));
        stateIdRegistration.remove(state.getLegacyStateId());
    }

    @PowerNukkitOnly
    public CompoundTag getBlockStateNbtTemplate(BlockID blockId) {
        return blockIdToDefaultNBT.get(blockId);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public int getBlockPaletteDataVersion() {
        @SuppressWarnings("UnnecessaryLocalVariable")
        Object obj = blockPaletteBytes;
        return obj.hashCode();
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    public byte[] getBlockPaletteBytes() {
        return blockPaletteBytes.clone();
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public void putBlockPaletteBytes(BinaryStream stream) {
        stream.put(blockPaletteBytes);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public int getBlockPaletteLength() {
        return blockPaletteBytes.length;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public void copyBlockPaletteBytes(byte[] target, int targetIndex) {
        System.arraycopy(blockPaletteBytes, 0, target, targetIndex, blockPaletteBytes.length);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @SuppressWarnings({"deprecation", "squid:CallToDepreca"})
    @Nonnull
    public BlockProperties getProperties(BlockID blockId) {
        if (Block.get(blockId) == null) {
            return CommonBlockProperties.EMPTY_PROPERTIES;
        }
        return Block.get(blockId).getProperties();
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    public MutableBlockState createMutableState(BlockID blockId) {
        return getProperties(blockId).createMutableState(blockId);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    public MutableBlockState createMutableState(BlockID blockId, int bigMeta) {
        MutableBlockState blockState = createMutableState(blockId);
        blockState.setDataStorageFromInt(bigMeta);
        return blockState;
    }

    /**
     * @throws InvalidBlockStateException
     */
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    public MutableBlockState createMutableState(BlockID blockId, Number storage) {
        MutableBlockState blockState = createMutableState(blockId);
        blockState.setDataStorage(storage);
        return blockState;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public int getUpdateBlockRegistration() {
        return updateBlockRegistration.runtimeId;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nullable
    public BlockID getBlockId(String name) {
        return BlockID.byIdentifier(name);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public int getFallbackRuntimeId() {
        return updateBlockRegistration.runtimeId;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockState getFallbackBlockState() {
        return updateBlockRegistration.state;
    }

    public String getPersistenceName(BlockID blockID) {
        return blockID.getIdentifier();
    }

    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    private static class Registration {
        @Nullable
        private BlockState state;

        private final int runtimeId;

        @Nullable
        private CompoundTag originalBlock;
    }
}
