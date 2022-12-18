package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.*;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.blockstate.*;
import cn.nukkit.blockstate.exception.InvalidBlockStateException;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.level.Level;
import cn.nukkit.level.MovingObjectPosition;
import cn.nukkit.level.Position;
import cn.nukkit.math.AxisAlignedBB;
import cn.nukkit.math.BlockFace;
import cn.nukkit.math.NukkitMath;
import cn.nukkit.math.Vector3;
import cn.nukkit.metadata.MetadataValue;
import cn.nukkit.metadata.Metadatable;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.potion.Effect;
import cn.nukkit.utils.BlockColor;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.extern.log4j.Log4j2;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static cn.nukkit.utils.Utils.dynamic;

/**
 * @author MagicDroidX (Nukkit Project)
 */
@PowerNukkitDifference(info = "Implements IMutableBlockState only on PowerNukkit", since = "1.4.0.0-PN")
@SuppressWarnings({"java:S2160", "java:S3400"})
@Log4j2
public abstract class Block extends Position implements Metadatable, Cloneable, AxisAlignedBB, IMutableBlockState {

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static final Block[] EMPTY_ARRAY = new Block[0];

    //<editor-fold desc="static fields" defaultstate="collapsed">
    @Deprecated
    @DeprecationDetails(since = "1.4.0.0-PN", reason = "It's not a constant value, it may be changed on major updates and" +
            " plugins will have to be recompiled in order to update this value in the binary files, " +
            "it's also being replaced by the BlockState system")
    @PowerNukkitOnly
    public static final int DATA_BITS = dynamic(4);

    @SuppressWarnings("DeprecatedIsStillUsed")
    @Deprecated
    @DeprecationDetails(since = "1.4.0.0-PN", reason = "It's not a constant value, it may be changed on major updates and" +
            " plugins will have to be recompiled in order to update this value in the binary files, " +
            "it's also being replaced by the BlockState system")
    @PowerNukkitOnly
    public static final int DATA_SIZE = dynamic(1 << DATA_BITS);

    @Deprecated
    @DeprecationDetails(since = "1.4.0.0-PN", reason = "It's not a constant value, it may be changed on major updates and" +
            " plugins will have to be recompiled in order to update this value in the binary files, " +
            "it's also being replaced by the BlockState system")
    @PowerNukkitOnly
    public static final int DATA_MASK = dynamic(DATA_SIZE - 1);

    @Deprecated
    @DeprecationDetails(reason = "Not encapsulated, easy to break", since = "1.4.0.0-PN",
            replaceWith = "Block.getLightLevel() or Block.getLightLevel(int)")
    @SuppressWarnings({"java:S1444", "java:S2386"})
    @SuppressFBWarnings(value = "MS_PKGPROTECT", justification = "Changing it would break compatibility with some regular Nukkit plugins")
    public static Map<BlockID, Integer> light = new HashMap<>();

    @Deprecated
    @DeprecationDetails(reason = "Not encapsulated, easy to break", since = "1.4.0.0-PN",
            replaceWith = "Block.getLightFilter() or Block.getLightFilter(int)")
    @SuppressWarnings({"java:S1444", "java:S2386", "DeprecatedIsStillUsed"})
    @SuppressFBWarnings(value = "MS_PKGPROTECT", justification = "Changing it would break compatibility with some regular Nukkit plugins")
    public static Map<BlockID, Integer> lightFilter = new HashMap<>();

    @Deprecated
    @DeprecationDetails(reason = "Not encapsulated, easy to break", since = "1.4.0.0-PN",
            replaceWith = "Block.isSolid() or Block.isSolid(int)")
    @SuppressWarnings({"java:S1444", "java:S2386"})
    @SuppressFBWarnings(value = "MS_PKGPROTECT", justification = "Changing it would break compatibility with some regular Nukkit plugins")
    public static Map<BlockID, Boolean> solid = new HashMap<>();

    @Deprecated
    @DeprecationDetails(reason = "Not encapsulated, easy to break", since = "1.4.0.0-PN",
            replaceWith = "Block.getHardness() or Block.getHardness(int)")
    @SuppressWarnings({"java:S1444", "java:S2386", "DeprecatedIsStillUsed"})
    @SuppressFBWarnings(value = "MS_PKGPROTECT", justification = "Changing it would break compatibility with some regular Nukkit plugins")
    public static Map<BlockID, Double> hardness = new HashMap<>();

    @Deprecated
    @DeprecationDetails(reason = "Not encapsulated, easy to break", since = "1.4.0.0-PN",
            replaceWith = "Block.isTransparent() or Block.isTransparent(int)")
    @SuppressWarnings({"java:S1444", "java:S2386", "DeprecatedIsStillUsed"})
    @SuppressFBWarnings(value = "MS_PKGPROTECT", justification = "Changing it would break compatibility with some regular Nukkit plugins")
    public static Map<BlockID, Boolean> transparent = new HashMap<>();

    public static Map<BlockID, Boolean> diffusesSkyLight = new HashMap<>();

    private static Int2ObjectMap<Block> blocks = new Int2ObjectOpenHashMap<>();

    private static boolean initializing;

    @PowerNukkitOnly
    @Since("1.3.0.0-PN")
    public static boolean isInitializing() {
        return initializing;
    }
    //</editor-fold>

    //<editor-fold desc="initialization" defaultstate="collapsed">
    @SuppressWarnings("unchecked")
    public static void init() {
        for (BlockID blockID : BlockID.values()) {
            final Class<? extends Block> clazz = blockID.getClazz();

            try {
                if (!Modifier.isAbstract(clazz.getModifiers())) {
                    BlockID id = null;

                    for (Constructor<?> constructor : clazz.getConstructors()) {
                        if (constructor.getParameterCount() > 0 && (constructor.getParameterTypes()[0].isAssignableFrom(int.class) || constructor.getParameterTypes()[0].isAssignableFrom(Integer.class))) {
                            id = clazz.getConstructor(constructor.getParameterTypes()[0]).newInstance(0).getId();
                        } else if (constructor.getParameterCount() == 0) {
                            id = clazz.getConstructor().newInstance().getId();
                        }
                    }

                    if (id != null) {
                        Block.registerBlockImplementation(id, clazz, false);
                    }
                }
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                     NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="static getters" defaultstate="collapsed">

    private static void assertRegistered(BlockID blockID) {
        if (!blocks.containsKey(blockID.ordinal())) {
            throw new IllegalStateException("Block " + blockID + " is not registered");
        }
    }

    public static Block get(BlockID id) {
        assertRegistered(id);
        return blocks.get(id.ordinal()).clone();
    }

    @PowerNukkitOnly
    @Deprecated
    @DeprecationDetails(reason = "The meta is limited to 32 bits", replaceWith = "BlockState.getBlock()", since = "1.4.0.0-PN")
    @SuppressWarnings("unchecked")
    public static Block get(BlockID id, int meta, Position pos, int layer) {
        return get(id, meta, pos.level, pos.getFloorX(), pos.getFloorY(), pos.getFloorZ(), layer);
    }

    @PowerNukkitOnly
    @Deprecated
    @DeprecationDetails(reason = "The meta is limited to 32 bits", replaceWith = "BlockState.getBlock()", since = "1.4.0.0-PN")
    @SuppressWarnings("unchecked")
    public static Block get(BlockID id, int meta, Position pos) {
        return get(id, meta, pos, 0);
    }

    @Deprecated
    @DeprecationDetails(reason = "The meta is limited to 32 bits", replaceWith = "BlockState.getBlock()", since = "1.4.0.0-PN")
    public static Block get(BlockID id, int data) {
        assertRegistered(id);
        Block block = get(id);
        block.setDamage(data);
        return block;
    }

    @Deprecated
    @DeprecationDetails(reason = "The meta is limited to 32 bits", replaceWith = "BlockState.getBlock()", since = "1.4.0.0-PN")
    @PowerNukkitOnly
    @Since("1.3.0.0-PN")
    public static Block get(BlockID id, int meta, Level level, int x, int y, int z) {
        return get(id, meta, level, x, y, z, 0);
    }

    @Deprecated
    @DeprecationDetails(reason = "The meta is limited to 32 bits", replaceWith = "BlockState.getBlock()", since = "1.4.0.0-PN")
    @PowerNukkitOnly
    @Since("1.3.0.0-PN")
    public static Block get(BlockID id, int meta, Level level, int x, int y, int z, int layer) {
        assertRegistered(id);
        Block block = get(id);
        block.setDamage(meta);
        block.x = x;
        block.y = y;
        block.z = z;
        block.level = level;
        block.layer = layer;
        return block;
    }
    //</editor-fold>

    @PowerNukkitOnly
    @Since("1.6.0.0-PN")
    @SuppressWarnings("java:S1874")
    public static boolean isSolid(BlockID blockId) {
        return solid.getOrDefault(blockId, false);
    }

    @PowerNukkitOnly
    @Since("1.6.0.0-PN")
    public static boolean diffusesSkyLight(BlockID blockId) {
        return diffusesSkyLight.getOrDefault(blockId, false);
    }

    @PowerNukkitOnly
    @Since("1.6.0.0-PN")
    @SuppressWarnings("java:S1874")
    public static double getHardness(BlockID blockId) {
        return hardness.getOrDefault(blockId, 0D);
    }

    @PowerNukkitOnly
    @Since("1.6.0.0-PN")
    @SuppressWarnings("java:S1874")
    public static int getLightLevel(BlockID blockId) {
        return light.getOrDefault(blockId, 0);
    }

    @PowerNukkitOnly
    @Since("1.6.0.0-PN")
    @SuppressWarnings("java:S1874")
    public static int getLightFilter(BlockID blockId) {
        return lightFilter.getOrDefault(blockId, 0);
    }

    @PowerNukkitOnly
    @Since("1.6.0.0-PN")
    @SuppressWarnings("java:S1874")
    public static boolean isTransparent(BlockID blockId) {
        return transparent.containsKey(blockId);
    }

    /**
     * Register a new block implementation overriding the existing one.
     *
     * @param blockId            The block ID that will be registered. Can't be negative.
     * @param blockClass         The class that overrides {@link Block} and implements this block,
     *                           it must have a constructor without params and optionally one that accepts {@code Number} or {@code int}
     * @param receivesRandomTick If the block should receive random ticks from the level
     */
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static void registerBlockImplementation(BlockID blockId, @Nonnull Class<? extends Block> blockClass, boolean receivesRandomTick) {
        Block mainBlock = null;
        BlockProperties properties;
        try {
            for (Constructor<?> constructor : blockClass.getConstructors()) {
                if (constructor.getParameterCount() > 0 && (constructor.getParameterTypes()[0].isAssignableFrom(int.class) || constructor.getParameterTypes()[0].isAssignableFrom(Integer.class))) {
                    mainBlock = (Block) constructor.newInstance(0);
                } else if (constructor.getParameterCount() == 0) {
                    mainBlock = (Block) constructor.newInstance();
                }
            }

            mainBlock.clone(); // Make sure clone works
            properties = mainBlock.getProperties();
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not create the main block of " + blockClass, e);
        }

        solid.put(blockId, mainBlock.isSolid());
        transparent.put(blockId, mainBlock.isTransparent());
        diffusesSkyLight.put(blockId, mainBlock.diffusesSkyLight());
        hardness.put(blockId, mainBlock.getHardness());
        light.put(blockId, mainBlock.getLightLevel());
        lightFilter.put(blockId, mainBlock.getLightFilter());
        blocks.put(blockId.ordinal(), mainBlock);

        Level.setCanRandomTick(blockId, receivesRandomTick);
    }

    @Nullable
    private MutableBlockState mutableState;

    @PowerNukkitOnly
    public int layer;

    protected Block() {
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    protected final MutableBlockState getMutableState() {
        if (mutableState == null) {
            mutableState = getProperties().createMutableState(getId());
        }
        return mutableState;
    }

    /**
     * Place and initialize a this block correctly in the world.
     * <p>The current instance must have level, x, y, z, and layer properties already set before calling this method.</p>
     *
     * @param item   The item being used to place the block. Should be used as an optional reference, may mismatch the block that is being placed depending on plugin implementations.
     * @param block  The current block that is in the world and is getting replaced by this instance. It has the same x, y, z, layer, and level as this block.
     * @param target The block that was clicked to create the place action in this block position.
     * @param face   The face that was clicked in the target block
     * @param fx     The detailed X coordinate of the clicked target block face
     * @param fy     The detailed Y coordinate of the clicked target block face
     * @param fz     The detailed Z coordinate of the clicked target block face
     * @param player The player that is placing the block. May be null.
     * @return {@code true} if the block was properly place. The implementation is responsible for reverting any partial change.
     */
    public boolean place(@Nonnull Item item, @Nonnull Block block, @Nonnull Block target, @Nonnull BlockFace face, double fx, double fy, double fz, @Nullable Player player) {
        return this.getLevel().setBlock(this, this, true, true);
    }

    //http://minecraft.gamepedia.com/Breaking
    public boolean canHarvestWithHand() {  //used for calculating breaking time
        return true;
    }

    public boolean isBreakable(Item item) {
        return true;
    }

    public int tickRate() {
        return 10;
    }

    public boolean onBreak(Item item) {
        return this.getLevel().setBlock(this, layer, Block.get(BlockID.AIR), true, true);
    }

    public int onUpdate(int type) {
        return 0;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public int onTouch(@Nullable Player player, PlayerInteractEvent.Action action) {
        return onUpdate(Level.BLOCK_UPDATE_TOUCH);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public void onNeighborChange(@Nonnull BlockFace side) {

    }

    public boolean onActivate(@Nonnull Item item) {
        return this.onActivate(item, null);
    }

    public boolean onActivate(@Nonnull Item item, @Nullable Player player) {
        return false;
    }

    @Since("1.2.1.0-PN")
    @PowerNukkitOnly
    public void afterRemoval(Block newBlock, boolean update) {
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public boolean isSoulSpeedCompatible() {
        return false;
    }

    public double getHardness() {
        return 10;
    }

    public double getResistance() {
        return 1;
    }

    public int getBurnChance() {
        return 0;
    }

    public int getBurnAbility() {
        return 0;
    }

    public int getToolType() {
        return ItemTool.TYPE_NONE;
    }

    public double getFrictionFactor() {
        return 0.6;
    }

    public int getLightLevel() {
        return 0;
    }

    public boolean canBePlaced() {
        return true;
    }

    public boolean canBeReplaced() {
        return false;
    }

    public boolean isTransparent() {
        return false;
    }

    public boolean isSolid() {
        return true;
    }

    /**
     * Check if blocks can be attached in the given side.
     */
    @PowerNukkitOnly
    @Since("1.3.0.0-PN")
    public boolean isSolid(BlockFace side) {
        return isSideFull(side);
    }

    // https://minecraft.gamepedia.com/Opacity#Lighting
    @PowerNukkitOnly
    public boolean diffusesSkyLight() {
        return false;
    }

    public boolean canBeFlowedInto() {
        return false;
    }

    @PowerNukkitOnly
    public int getWaterloggingLevel() {
        return 0;
    }

    @PowerNukkitOnly
    public final boolean canWaterloggingFlowInto() {
        return canBeFlowedInto() || getWaterloggingLevel() > 1;
    }

    public boolean canBeActivated() {
        return false;
    }

    public boolean hasEntityCollision() {
        return false;
    }

    public boolean canPassThrough() {
        return false;
    }

    public boolean canBePushed() {
        return true;
    }

    @PowerNukkitOnly
    public boolean canBePulled() {
        return true;
    }

    @PowerNukkitOnly
    public boolean breaksWhenMoved() {
        return false;
    }

    @PowerNukkitOnly
    public boolean sticksToPiston() {
        return true;
    }

    public boolean hasComparatorInputOverride() {
        return false;
    }

    public int getComparatorInputOverride() {
        return 0;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public boolean canHarvest(Item item) {
        return getToolTier() == 0 || getToolType() == 0 || correctTool0(getToolType(), item, getId()) && item.getTier() >= getToolTier();
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public int getToolTier() {
        return 0;
    }

    public boolean canBeClimbed() {
        return false;
    }

    public BlockColor getColor() {
        return BlockColor.VOID_BLOCK_COLOR;
    }

    public abstract String getName();

    public abstract BlockID getId();

    @PowerNukkitOnly
    public ItemID getItemId() {
        for (ItemID itemID : ItemID.values()) {
            if (itemID.getIdentifier().equals(this.getId().getIdentifier())) {
                return itemID;
            }
        }

        return ItemID.AIR;
    }

    /**
     * The properties that fully describe all possible and valid states that this block can have.
     */
    @Override
    @Nonnull
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockProperties getProperties() {
        return CommonBlockProperties.EMPTY_PROPERTIES;
    }

    @Override
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    public final BlockState getCurrentState() {
        return mutableState == null ? BlockState.of(getId(), getDamage()) : mutableState.getCurrentState();
    }

    @Override
    @PowerNukkitOnly
    @Since("1.3.0.0-PN")
    public final int getRuntimeId() {
        return getCurrentState().getRuntimeId();
    }

    public void addVelocityToEntity(Entity entity, Vector3 vector) {

    }

    @Deprecated
    @DeprecationDetails(reason = "Limited to 32 bits", since = "1.4.0.0-PN")
    public int getDamage() {
        return mutableState == null ? 0 : mutableState.getBigDamage();
    }

    @Deprecated
    @DeprecationDetails(reason = "Limited to 32 bits", since = "1.4.0.0-PN")
    public void setDamage(int meta) {
        if (meta == 0 && isDefaultState()) {
            return;
        }
        getMutableState().setDataStorageFromInt(meta);
    }

    @Deprecated
    @DeprecationDetails(reason = "Limited to 32 bits", since = "1.4.0.0-PN")
    public final void setDamage(Integer meta) {
        setDamage((meta == null ? 0 : meta & 0x0f));
    }

    final public void position(Position v) {
        this.x = (int) v.x;
        this.y = (int) v.y;
        this.z = (int) v.z;
        this.level = v.level;
    }

    public Item[] getDrops(Item item) {
        if (canHarvestWithHand() || canHarvest(item)) {
            return new Item[]{
                    this.toItem()
            };
        }
        return Item.EMPTY_ARRAY;
    }

    private double toolBreakTimeBonus0(Item item) {
        return toolBreakTimeBonus0(toolType0(item, getId()), item.getTier(), getId());
    }

    private static double toolBreakTimeBonus0(int toolType, int toolTier, BlockID blockId) {
        if (toolType == ItemTool.TYPE_SWORD) {
            if (blockId == BlockID.WEB) {
                return 15.0;
            }
            if (blockId == BlockID.BAMBOO) {
                return 30.0;
            }
            return 1.0;
        }
        if (toolType == ItemTool.TYPE_SHEARS) {
            if (blockId == BlockID.WOOL || blockId == BlockID.LEAVES || blockId == BlockID.LEAVES2) {
                return 5.0;
            } else if (blockId == BlockID.WEB) {
                return 15.0;
            }
            return 1.0;
        }
        if (toolType == ItemTool.TYPE_NONE) return 1.0;
        switch (toolTier) {
            case ItemTool.TIER_WOODEN:
                return 2.0;
            case ItemTool.TIER_STONE:
                return 4.0;
            case ItemTool.TIER_IRON:
                return 6.0;
            case ItemTool.TIER_DIAMOND:
                return 8.0;
            case ItemTool.TIER_NETHERITE:
                return 9.0;
            case ItemTool.TIER_GOLD:
                return 12.0;
            default:
                if (toolTier == ItemTool.TIER_NETHERITE) {
                    return 9.0;
                }
                return 1.0;
        }
    }

    private static double speedBonusByEfficiencyLore0(int efficiencyLoreLevel) {
        if (efficiencyLoreLevel == 0) return 0;
        return efficiencyLoreLevel * efficiencyLoreLevel + 1;
    }

    private static double speedRateByHasteLore0(int hasteLoreLevel) {
        return 1.0 + (0.2 * hasteLoreLevel);
    }

    @PowerNukkitDifference(info = "Special condition for the leaves", since = "1.4.0.0-PN")
    private static int toolType0(Item item, BlockID blockId) {
        if ((blockId == BlockID.LEAVES && item.isHoe()) || (blockId == BlockID.LEAVES2 && item.isHoe()))
            return ItemTool.TYPE_SHEARS;
        if (item.isSword()) return ItemTool.TYPE_SWORD;
        if (item.isShovel()) return ItemTool.TYPE_SHOVEL;
        if (item.isPickaxe()) return ItemTool.TYPE_PICKAXE;
        if (item.isAxe()) return ItemTool.TYPE_AXE;
        if (item.isHoe()) return ItemTool.TYPE_HOE;
        if (item.isShears()) return ItemTool.TYPE_SHEARS;
        return ItemTool.TYPE_NONE;
    }

    @PowerNukkitDifference(info = "Special condition for the leaves and cobweb", since = "1.4.0.0-PN")
    private static boolean correctTool0(int blockToolType, Item item, BlockID blockId) {
        if ((blockId == BlockID.LEAVES && item.isHoe()) ||
                (blockId == BlockID.LEAVES2 && item.isHoe())) {
            return (blockToolType == ItemTool.TYPE_SHEARS && item.isHoe());
        } else if (blockId == BlockID.BAMBOO && item.isSword()) {
            return (blockToolType == ItemTool.TYPE_AXE && item.isSword());
        } else return (blockToolType == ItemTool.TYPE_SWORD && item.isSword()) ||
                (blockToolType == ItemTool.TYPE_SHOVEL && item.isShovel()) ||
                (blockToolType == ItemTool.TYPE_PICKAXE && item.isPickaxe()) ||
                (blockToolType == ItemTool.TYPE_AXE && item.isAxe()) ||
                (blockToolType == ItemTool.TYPE_HOE && item.isHoe()) ||
                (blockToolType == ItemTool.TYPE_SHEARS && item.isShears()) ||
                blockToolType == ItemTool.TYPE_NONE ||
                (blockId == BlockID.WEB && item.isShears());
    }

    //http://minecraft.gamepedia.com/Breaking
    private static double breakTime0(double blockHardness, boolean correctTool, boolean canHarvestWithHand,
                                     BlockID blockId, int toolType, int toolTier, int efficiencyLoreLevel, int hasteEffectLevel,
                                     boolean insideOfWaterWithoutAquaAffinity, boolean outOfWaterButNotOnGround) {
        double baseTime = ((correctTool || canHarvestWithHand) ? 1.5 : 5.0) * blockHardness;
        double speed = 1.0 / baseTime;
        if (correctTool) speed *= toolBreakTimeBonus0(toolType, toolTier, blockId);
        speed += correctTool ? speedBonusByEfficiencyLore0(efficiencyLoreLevel) : 0;
        speed *= speedRateByHasteLore0(hasteEffectLevel);
        if (insideOfWaterWithoutAquaAffinity) speed *= 0.2;
        if (outOfWaterButNotOnGround) speed *= 0.2;
        return 1.0 / speed;
    }

    @Nonnull
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public double calculateBreakTime(@Nonnull Item item) {
        return calculateBreakTime(item, null);
    }

    @Nonnull
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public double calculateBreakTime(@Nonnull Item item, @Nullable Player player) {
        double seconds = 0;
        double blockHardness = getHardness();
        boolean canHarvest = canHarvest(item);

        if (canHarvest) {
            seconds = blockHardness * 1.5;
        } else {
            seconds = blockHardness * 5;
        }

        double speedMultiplier = 1;
        boolean hasConduitPower = false;
        boolean hasAquaAffinity = false;
        int hasteEffectLevel = 0;
        int miningFatigueLevel = 0;

        if (player != null) {
            hasConduitPower = player.hasEffect(Effect.CONDUIT_POWER);
            hasAquaAffinity = Optional.ofNullable(player.getInventory().getHelmet().getEnchantment(Enchantment.ID_WATER_WORKER))
                    .map(Enchantment::getLevel).map(l -> l >= 1).orElse(false);
            hasteEffectLevel = Optional.ofNullable(player.getEffect(Effect.HASTE))
                    .map(Effect::getAmplifier).orElse(0);
            miningFatigueLevel = Optional.ofNullable(player.getEffect(Effect.MINING_FATIGUE))
                    .map(Effect::getAmplifier).orElse(0);
        }

        if (correctTool0(getToolType(), item, getId())) {
            speedMultiplier = toolBreakTimeBonus0(item);

            int efficiencyLevel = Optional.ofNullable(item.getEnchantment(Enchantment.ID_EFFICIENCY))
                    .map(Enchantment::getLevel).orElse(0);

            if (canHarvest && efficiencyLevel > 0) {
                speedMultiplier += Math.pow(efficiencyLevel, 2) + 1;
            }

            if (hasConduitPower) hasteEffectLevel = Integer.max(hasteEffectLevel, 2);

            if (hasteEffectLevel > 0) {
                speedMultiplier *= 1 + (0.2 * hasteEffectLevel);
            }

        }

        if (miningFatigueLevel > 0) {
            speedMultiplier /= 3 ^ miningFatigueLevel;
        }

        seconds /= speedMultiplier;

        if (player != null) {
            if (player.isInsideOfWater() && !hasAquaAffinity) {
                seconds *= hasConduitPower && blockHardness >= 0.5 ? 2.5 : 5;
            }

            if (!player.isOnGround()) {
                seconds *= 5;
            }
        }

        return seconds;
    }

    @DeprecationDetails(since = "1.4.0.0-PN", reason = "Not completely accurate", replaceWith = "calculateBreakeTime()")
    @Deprecated
    @PowerNukkitDifference(info = "Special condition for the leaves", since = "1.4.0.0-PN")
    public double getBreakTime(Item item, Player player) {
        Objects.requireNonNull(item, "getBreakTime: Item can not be null");
        Objects.requireNonNull(player, "getBreakTime: Player can not be null");
        double blockHardness = getHardness();

        if (blockHardness == 0) {
            return 0;
        }

        BlockID blockId = getId();
        boolean correctTool = correctTool0(getToolType(), item, blockId);
        boolean canHarvestWithHand = canHarvestWithHand();
        int itemToolType = toolType0(item, blockId);
        int itemTier = item.getTier();
        int efficiencyLoreLevel = Optional.ofNullable(item.getEnchantment(Enchantment.ID_EFFICIENCY))
                .map(Enchantment::getLevel).orElse(0);
        int hasteEffectLevel = Optional.ofNullable(player.getEffect(Effect.HASTE))
                .map(Effect::getAmplifier).orElse(0);
        //TODO Fix the break time with CONDUIT_POWER, it's not right
        int conduitPowerLevel = Optional.ofNullable(player.getEffect(Effect.CONDUIT_POWER))
                .map(e -> /*(e.getAmplifier() +1) * 4*/ e.getAmplifier())
                .orElse(0);
        hasteEffectLevel += conduitPowerLevel;
        boolean insideOfWaterWithoutAquaAffinity = player.isInsideOfWater() && conduitPowerLevel <= 0 &&
                Optional.ofNullable(player.getInventory().getHelmet().getEnchantment(Enchantment.ID_WATER_WORKER))
                        .map(Enchantment::getLevel).map(l -> l >= 1).orElse(false);
        boolean outOfWaterButNotOnGround = (!player.isInsideOfWater()) && (!player.isOnGround());
        return breakTime0(blockHardness, correctTool, canHarvestWithHand, blockId, itemToolType, itemTier,
                efficiencyLoreLevel, hasteEffectLevel, insideOfWaterWithoutAquaAffinity, outOfWaterButNotOnGround);
    }

    /**
     * @param item item used
     * @return break time
     * @deprecated This function is lack of Player class and is not accurate enough, use {@link #getBreakTime(Item, Player)}
     */
    @PowerNukkitDifference(info = "Special condition for the hoe and netherie support", since = "1.4.0.0-PN")
    @Deprecated
    public double getBreakTime(Item item) {
        double base = this.getHardness() * 1.5;
        if (this.canBeBrokenWith(item)) {
            if (
                    (this.getToolType() == ItemTool.TYPE_SHEARS && item.isShears()) ||
                            (this.getToolType() == ItemTool.TYPE_SHEARS && item.isHoe())) {
                base /= 15;
            } else if (
                    (this.getToolType() == ItemTool.TYPE_PICKAXE && item.isPickaxe()) ||
                            (this.getToolType() == ItemTool.TYPE_AXE && item.isAxe()) ||
                            (this.getToolType() == ItemTool.TYPE_SHOVEL && item.isShovel()) ||
                            (this.getToolType() == ItemTool.TYPE_HOE && item.isHoe())
            ) {
                int tier = item.getTier();
                switch (tier) {
                    case ItemTool.TIER_WOODEN:
                        base /= 2;
                        break;
                    case ItemTool.TIER_STONE:
                        base /= 4;
                        break;
                    case ItemTool.TIER_IRON:
                        base /= 6;
                        break;
                    case ItemTool.TIER_DIAMOND:
                        base /= 8;
                        break;
                    case ItemTool.TIER_NETHERITE:
                        base /= 9;
                        break;
                    case ItemTool.TIER_GOLD:
                        base /= 12;
                        break;
                }
            }
        } else {
            base *= 3.33;
        }

        if (item.isSword()) {
            base *= 0.5;
        }

        return base;
    }

    public boolean canBeBrokenWith(Item item) {
        return this.getHardness() != -1;
    }

    @Override
    public Block getSide(BlockFace face) {
        return getSideAtLayer(layer, face);
    }

    @Override
    public Block getSide(BlockFace face, int step) {
        return getSideAtLayer(layer, face, step);
    }

    @PowerNukkitOnly
    public Block getSideAtLayer(int layer, BlockFace face) {
        if (this.isValid()) {
            return this.getLevel().getBlock((int) x + face.getXOffset(), (int) y + face.getYOffset(), (int) z + face.getZOffset(), layer);
        }
        return this.getSide(face, 1);
    }

    @PowerNukkitOnly
    public Block getSideAtLayer(int layer, BlockFace face, int step) {
        if (this.isValid()) {
            if (step == 1) {
                return this.getLevel().getBlock((int) x + face.getXOffset(), (int) y + face.getYOffset(), (int) z + face.getZOffset(), layer);
            } else {
                return this.getLevel().getBlock((int) x + face.getXOffset() * step, (int) y + face.getYOffset() * step, (int) z + face.getZOffset() * step, layer);
            }
        }
        Block block = Block.get(BlockID.AIR, 0);
        block.x = (int) x + face.getXOffset() * step;
        block.y = (int) y + face.getYOffset() * step;
        block.z = (int) z + face.getZOffset() * step;
        block.layer = layer;
        return block;
    }

    @Override
    public Block up() {
        return up(1);
    }

    @Override
    public Block up(int step) {
        return getSide(BlockFace.UP, step);
    }

    @PowerNukkitOnly
    public Block up(int step, int layer) {
        return getSideAtLayer(layer, BlockFace.UP, step);
    }

    @Override
    public Block down() {
        return down(1);
    }

    @Override
    public Block down(int step) {
        return getSide(BlockFace.DOWN, step);
    }

    @PowerNukkitOnly
    public Block down(int step, int layer) {
        return getSideAtLayer(layer, BlockFace.DOWN, step);
    }

    @Override
    public Block north() {
        return north(1);
    }

    @Override
    public Block north(int step) {
        return getSide(BlockFace.NORTH, step);
    }

    @PowerNukkitOnly
    public Block north(int step, int layer) {
        return getSideAtLayer(layer, BlockFace.NORTH, step);
    }

    @Override
    public Block south() {
        return south(1);
    }

    @Override
    public Block south(int step) {
        return getSide(BlockFace.SOUTH, step);
    }

    @PowerNukkitOnly
    public Block south(int step, int layer) {
        return getSideAtLayer(layer, BlockFace.SOUTH, step);
    }

    @Override
    public Block east() {
        return east(1);
    }

    @Override
    public Block east(int step) {
        return getSide(BlockFace.EAST, step);
    }

    @PowerNukkitOnly
    public Block east(int step, int layer) {
        return getSideAtLayer(layer, BlockFace.EAST, step);
    }

    @Override
    public Block west() {
        return west(1);
    }

    @Override
    public Block west(int step) {
        return getSide(BlockFace.WEST, step);
    }

    @PowerNukkitOnly
    public Block west(int step, int layer) {
        return getSideAtLayer(layer, BlockFace.WEST, step);
    }

    @Override
    public String toString() {
        return "Block[" + this.getName() + "] (" + this.getId() + ":" + (mutableState != null ? mutableState.getDataStorage() : "0") + ")" +
                (isValid() ? " at " + super.toString() : "");
    }

    public boolean collidesWithBB(AxisAlignedBB bb) {
        return collidesWithBB(bb, false);
    }

    public boolean collidesWithBB(AxisAlignedBB bb, boolean collisionBB) {
        AxisAlignedBB bb1 = collisionBB ? this.getCollisionBoundingBox() : this.getBoundingBox();
        return bb1 != null && bb.intersectsWith(bb1);
    }

    public void onEntityCollide(Entity entity) {

    }

    public AxisAlignedBB getBoundingBox() {
        return this.recalculateBoundingBox();
    }

    public AxisAlignedBB getCollisionBoundingBox() {
        return this.recalculateCollisionBoundingBox();
    }

    protected AxisAlignedBB recalculateBoundingBox() {
        return this;
    }

    @Override
    public double getMinX() {
        return this.x;
    }

    @Override
    public double getMinY() {
        return this.y;
    }

    @Override
    public double getMinZ() {
        return this.z;
    }

    @Override
    public double getMaxX() {
        return this.x + 1;
    }

    @Override
    public double getMaxY() {
        return this.y + 1;
    }

    @Override
    public double getMaxZ() {
        return this.z + 1;
    }

    protected AxisAlignedBB recalculateCollisionBoundingBox() {
        return getBoundingBox();
    }

    @Override
    public MovingObjectPosition calculateIntercept(Vector3 pos1, Vector3 pos2) {
        AxisAlignedBB bb = this.getBoundingBox();
        if (bb == null) {
            return null;
        }

        Vector3 v1 = pos1.getIntermediateWithXValue(pos2, bb.getMinX());
        Vector3 v2 = pos1.getIntermediateWithXValue(pos2, bb.getMaxX());
        Vector3 v3 = pos1.getIntermediateWithYValue(pos2, bb.getMinY());
        Vector3 v4 = pos1.getIntermediateWithYValue(pos2, bb.getMaxY());
        Vector3 v5 = pos1.getIntermediateWithZValue(pos2, bb.getMinZ());
        Vector3 v6 = pos1.getIntermediateWithZValue(pos2, bb.getMaxZ());

        if (v1 != null && !bb.isVectorInYZ(v1)) {
            v1 = null;
        }

        if (v2 != null && !bb.isVectorInYZ(v2)) {
            v2 = null;
        }

        if (v3 != null && !bb.isVectorInXZ(v3)) {
            v3 = null;
        }

        if (v4 != null && !bb.isVectorInXZ(v4)) {
            v4 = null;
        }

        if (v5 != null && !bb.isVectorInXY(v5)) {
            v5 = null;
        }

        if (v6 != null && !bb.isVectorInXY(v6)) {
            v6 = null;
        }

        Vector3 vector = v1;

        if (v2 != null && (vector == null || pos1.distanceSquared(v2) < pos1.distanceSquared(vector))) {
            vector = v2;
        }

        if (v3 != null && (vector == null || pos1.distanceSquared(v3) < pos1.distanceSquared(vector))) {
            vector = v3;
        }

        if (v4 != null && (vector == null || pos1.distanceSquared(v4) < pos1.distanceSquared(vector))) {
            vector = v4;
        }

        if (v5 != null && (vector == null || pos1.distanceSquared(v5) < pos1.distanceSquared(vector))) {
            vector = v5;
        }

        if (v6 != null && (vector == null || pos1.distanceSquared(v6) < pos1.distanceSquared(vector))) {
            vector = v6;
        }

        if (vector == null) {
            return null;
        }

        BlockFace f = null;

        if (vector == v1) {
            f = BlockFace.WEST;
        } else if (vector == v2) {
            f = BlockFace.EAST;
        } else if (vector == v3) {
            f = BlockFace.DOWN;
        } else if (vector == v4) {
            f = BlockFace.UP;
        } else if (vector == v5) {
            f = BlockFace.NORTH;
        } else if (vector == v6) {
            f = BlockFace.SOUTH;
        }

        return MovingObjectPosition.fromBlock((int) this.x, (int) this.y, (int) this.z, f, vector.add(this.x, this.y, this.z));
    }

    public String getSaveId() {
        String name = getClass().getName();
        return name.substring(16);
    }

    @Override
    public void setMetadata(String metadataKey, MetadataValue newMetadataValue) throws Exception {
        if (this.getLevel() != null) {
            this.getLevel().getBlockMetadata().setMetadata(this, metadataKey, newMetadataValue);
        }
    }

    @Override
    public List<MetadataValue> getMetadata(String metadataKey) throws Exception {
        if (this.getLevel() != null) {
            return this.getLevel().getBlockMetadata().getMetadata(this, metadataKey);

        }
        return null;
    }

    @Override
    public boolean hasMetadata(String metadataKey) throws Exception {
        return this.getLevel() != null && this.getLevel().getBlockMetadata().hasMetadata(this, metadataKey);
    }

    @Override
    public void removeMetadata(String metadataKey, Plugin owningPlugin) throws Exception {
        if (this.getLevel() != null) {
            this.getLevel().getBlockMetadata().removeMetadata(this, metadataKey, owningPlugin);
        }
    }

    @Override
    public Block clone() {
        Block clone = (Block) super.clone();
        clone.mutableState = mutableState != null ? mutableState.copy() : null;
        return clone;
    }

    public int getWeakPower(BlockFace face) {
        return 0;
    }

    public int getStrongPower(BlockFace side) {
        return 0;
    }

    public boolean isPowerSource() {
        return false;
    }

    public String getLocationHash() {
        return this.getFloorX() + ":" + this.getFloorY() + ":" + this.getFloorZ();
    }

    public int getDropExp() {
        return 0;
    }

    /**
     * Check if the block is not transparent, is solid and can't provide redstone power.
     */
    public boolean isNormalBlock() {
        return !isTransparent() && isSolid() && !isPowerSource();
    }

    /**
     * Check if the block is not transparent, is solid and is a full cube like a stone block.
     */
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public boolean isSimpleBlock() {
        return !isTransparent() && isSolid() && isFullBlock();
    }

    /**
     * Check if the given face is fully occupied by the block bounding box.
     *
     * @param face The face to be checked
     * @return If and ony if the bounding box completely cover the face
     */
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public boolean isSideFull(BlockFace face) {
        AxisAlignedBB boundingBox = getBoundingBox();
        if (boundingBox == null) {
            return false;
        }

        if (face.getAxis().getPlane() == BlockFace.Plane.HORIZONTAL) {
            if (boundingBox.getMinY() != getY() || boundingBox.getMaxY() != getY() + 1) {
                return false;
            }
            int offset = face.getXOffset();
            if (offset < 0) {
                return boundingBox.getMinX() == getX()
                        && boundingBox.getMinZ() == getZ() && boundingBox.getMaxZ() == getZ() + 1;
            } else if (offset > 0) {
                return boundingBox.getMaxX() == getX() + 1
                        && boundingBox.getMaxZ() == getZ() + 1 && boundingBox.getMinZ() == getZ();
            }

            offset = face.getZOffset();
            if (offset < 0) {
                return boundingBox.getMinZ() == getZ()
                        && boundingBox.getMinX() == getX() && boundingBox.getMaxX() == getX() + 1;
            }

            return boundingBox.getMaxZ() == getZ() + 1
                    && boundingBox.getMaxX() == getX() + 1 && boundingBox.getMinX() == getX();
        }

        if (boundingBox.getMinX() != getX() || boundingBox.getMaxX() != getX() + 1 ||
                boundingBox.getMinZ() != getZ() || boundingBox.getMaxZ() != getZ() + 1) {
            return false;
        }

        if (face.getYOffset() < 0) {
            return boundingBox.getMinY() == getY();
        }

        return boundingBox.getMaxY() == getY() + 1;
    }

    /**
     * Check if the block occupies the entire block space, like a stone and normal glass blocks
     */
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public boolean isFullBlock() {
        AxisAlignedBB boundingBox = getBoundingBox();
        if (boundingBox == null) {
            return false;
        }
        return boundingBox.getMinX() == getX() && boundingBox.getMaxX() == getX() + 1
                && boundingBox.getMinY() == getY() && boundingBox.getMaxY() == getY() + 1
                && boundingBox.getMinZ() == getZ() && boundingBox.getMaxZ() == getZ() + 1;
    }

    public static boolean equals(Block b1, Block b2) {
        return equals(b1, b2, true);
    }

    public static boolean equals(Block b1, Block b2, boolean checkDamage) {
        if (b1 == null || b2 == null || b1.getId() != b2.getId()) {
            return false;
        }
        if (checkDamage) {
            boolean b1Default = b1.isDefaultState();
            boolean b2Default = b2.isDefaultState();
            if (b1Default != b2Default) {
                return false;
            } else if (b1Default) { // both are default
                return true;
            } else {
                return b1.getMutableState().equals(b2.getMutableState());
            }
        } else {
            return true;
        }
    }

    @PowerNukkitDifference(
            info = "Prevents players from getting invalid items by limiting the return to the maximum damage defined in getMaxItemDamage()",
            since = "1.4.0.0-PN")
    public Item toItem() {
        return Item.get(ItemID.AIR);
    }

    /**
     * If the block, when in item form, is resistant to lava and fire and can float on lava like if it was on water.
     *
     * @since 1.4.0.0-PN
     */
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public boolean isLavaResistant() {
        return false;
    }

    public boolean canSilkTouch() {
        return false;
    }

    @PowerNukkitOnly
    @Since("1.2.1.0-PN")
    public boolean mustSilkTouch(Vector3 vector, int layer, BlockFace face, Item item, Player player) {
        return false;
    }

    @PowerNukkitOnly
    @Since("1.2.1.0-PN")
    public boolean mustDrop(Vector3 vector, int layer, BlockFace face, Item item, Player player) {
        return false;
    }

    @PowerNukkitOnly
    public Optional<Block> firstInLayers(Predicate<Block> condition) {
        return firstInLayers(0, condition);
    }

    @PowerNukkitOnly
    public Optional<Block> firstInLayers(int startingLayer, Predicate<Block> condition) {
        int maximumLayer = this.level.requireProvider().getMaximumLayer();
        for (int layer = startingLayer; layer <= maximumLayer; layer++) {
            Block block = this.getLevelBlockAtLayer(layer);
            if (condition.test(block)) {
                return Optional.of(block);
            }
        }

        return Optional.empty();
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public void setState(@Nonnull IBlockState state) throws InvalidBlockStateException {
        if (state.getBlockId() == getId() && this.isDefaultState() && state.isDefaultState()) {
            return;
        }
        getMutableState().setState(state);
    }

    @Since("1.5.1.0-PN")
    @PowerNukkitOnly
    @Override
    @Nonnull
    public Block forState(@Nonnull IBlockState state) throws InvalidBlockStateException {
        return (Block) IMutableBlockState.super.forState(state);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public void setDataStorage(@Nonnegative @Nonnull Number storage) {
        if (NukkitMath.isZero(storage) && isDefaultState()) {
            return;
        }
        getMutableState().setDataStorage(storage);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public void setDataStorageFromInt(@Nonnegative int storage) {
        if (storage == 0 && isDefaultState()) {
            return;
        }
        getMutableState().setDataStorageFromInt(storage);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public boolean setDataStorage(@Nonnegative @Nonnull Number storage, boolean repair, Consumer<BlockStateRepair> callback) {
        if (NukkitMath.isZero(storage) && isDefaultState()) {
            return false;
        }
        return getMutableState().setDataStorage(storage, repair, callback);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public boolean setDataStorageFromInt(@Nonnegative int storage, boolean repair, Consumer<BlockStateRepair> callback) {
        if (storage == 0 && isDefaultState()) {
            return false;
        }
        return getMutableState().setDataStorageFromInt(storage, repair, callback);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public void setPropertyValue(@Nonnull String propertyName, @Nullable Serializable value) {
        if (isDefaultState() && getProperties().isDefaultValue(propertyName, value)) {
            return;
        }
        getMutableState().setPropertyValue(propertyName, value);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public void setBooleanValue(@Nonnull String propertyName, boolean value) {
        if (isDefaultState() && getProperties().isDefaultBooleanValue(propertyName, value)) {
            return;
        }
        getMutableState().setBooleanValue(propertyName, value);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public void setIntValue(@Nonnull String propertyName, int value) {
        if (isDefaultState() && getProperties().isDefaultIntValue(propertyName, value)) {
            return;
        }
        getMutableState().setIntValue(propertyName, value);
    }

    @Nonnegative
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    @Deprecated
    @DeprecationDetails(reason = "Does the same as getId() but the other is compatible with NukkitX and this is not", since = "1.4.0.0-PN")
    public final BlockID getBlockId() {
        return getId();
    }

    @Nonnegative
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    @Override
    public final Number getDataStorage() {
        return mutableState == null ? 0 : mutableState.getDataStorage();
    }

    @Nonnegative
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Deprecated
    @DeprecationDetails(reason = "Can't store all data, exists for backward compatibility reasons", since = "1.4.0.0-PN", replaceWith = "getDataStorage()")
    @Override
    public int getLegacyDamage() {
        return mutableState == null ? 0 : mutableState.getLegacyDamage();
    }

    @Unsigned
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Deprecated
    @DeprecationDetails(reason = "Can't store all data, exists for backward compatibility reasons", since = "1.4.0.0-PN", replaceWith = "getDataStorage()")
    @Override
    public int getBigDamage() {
        return mutableState == null ? 0 : mutableState.getBigDamage();
    }

    @Nonnegative
    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Deprecated
    @DeprecationDetails(reason = "Can't store all data, exists for backward compatibility reasons", since = "1.4.0.0-PN", replaceWith = "getDataStorage()")
    @Override
    public int getSignedBigDamage() {
        return mutableState == null ? 0 : mutableState.getSignedBigDamage();
    }

    @Nonnegative
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    @Override
    public BigInteger getHugeDamage() {
        return mutableState == null ? BigInteger.ZERO : mutableState.getHugeDamage();
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    @Override
    public Serializable getPropertyValue(@Nonnull String propertyName) {
        if (isDefaultState()) {
            return getProperties().getBlockProperty(propertyName).getDefaultValue();
        }
        return getMutableState().getPropertyValue(propertyName);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public int getIntValue(@Nonnull String propertyName) {
        if (isDefaultState()) {
            return getProperties().getBlockProperty(propertyName).getDefaultIntValue();
        }
        return getMutableState().getIntValue(propertyName);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public boolean getBooleanValue(@Nonnull String propertyName) {
        if (isDefaultState()) {
            return getProperties().getBlockProperty(propertyName).getDefaultBooleanValue();
        }
        return getMutableState().getBooleanValue(propertyName);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    @Override
    public String getPersistenceValue(@Nonnull String propertyName) {
        if (isDefaultState()) {
            return getProperties().getBlockProperty(propertyName).getPersistenceValueForMeta(0);
        }
        return getMutableState().getPersistenceValue(propertyName);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public final int getExactIntStorage() {
        return mutableState == null ? 0 : mutableState.getExactIntStorage();
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public boolean isBreakable(@Nonnull Vector3 vector, int layer, @Nonnull BlockFace face, @Nonnull Item item, @Nullable Player player, boolean setBlockDestroy) {
        return true;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public final boolean isBlockChangeAllowed() {
        return getChunk().isBlockChangeAllowed(getFloorX() & 0xF, getFloorY(), getFloorZ() & 0xF);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public final boolean isBlockChangeAllowed(@Nullable Player player) {
        if (isBlockChangeAllowed()) {
            return true;
        }
        return player != null && player.isCreative() && player.isOp();
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public int getLightFilter() {
        return isSolid() && !isTransparent() ? 15 : 1;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public final boolean canRandomTick() {
        return Level.canRandomTick(getId());
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public boolean onProjectileHit(@Nonnull Entity projectile, @Nonnull Position position, @Nonnull Vector3 motion) {
        return false;
    }

    @PowerNukkitOnly
    @Nonnull
    @Override
    public final Block getBlock() {
        return clone();
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public boolean isDefaultState() {
        return mutableState == null || mutableState.isDefaultState();
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public int getItemMaxStackSize() {
        return 64;
    }

    /**
     * Check if a block is getting powered threw a block or directly.
     *
     * @return if the gets powered.
     */
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @PowerNukkitDifference(info = "Used so often, why not create own method here?", since = "1.4.0.0-PN")
    public boolean isGettingPower() {
        if (!this.level.getServer().isRedstoneEnabled()) return false;

        for (BlockFace side : BlockFace.values()) {
            Block b = this.getSide(side).getLevelBlock();

            if (this.level.isSidePowered(b.getLocation(), side)) {
                return true;
            }
        }
        return this.level.isBlockPowered(this.getLocation());
    }

    @PowerNukkitOnly
    public boolean isAny(BlockID... ids) {
        for (BlockID id : ids) {
            if (id == getId()) {
                return true;
            }
        }

        return false;
    }
}
