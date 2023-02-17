package cn.nukkit.utils;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.Block;
import cn.nukkit.entity.Attribute;
import cn.nukkit.entity.data.Skin;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.level.GameRule;
import cn.nukkit.level.GameRules;
import cn.nukkit.math.BlockFace;
import cn.nukkit.math.BlockVector3;
import cn.nukkit.math.Vector3f;
import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.ListTag;
import cn.nukkit.nbt.tag.StringTag;
import cn.nukkit.network.LittleEndianByteBufInputStream;
import cn.nukkit.network.LittleEndianByteBufOutputStream;
import cn.nukkit.network.protocol.Protocol;
import cn.nukkit.network.protocol.types.*;
import cn.nukkit.network.protocol.types.itemrequestaction.*;
import cn.nukkit.network.protocol.types.transaction.Transaction;
import cn.nukkit.network.protocol.types.transaction.TransactionAction;
import cn.nukkit.network.protocol.types.transaction.TransactionActionSourceType;
import cn.nukkit.network.protocol.types.transaction.TransactionLegacy;
import cn.nukkit.network.protocol.types.transaction.data.TransactionUseItem;
import cn.nukkit.network.protocol.types.transaction.data.TransactionUseItemActionType;
import io.netty.buffer.AbstractByteBufAllocator;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.internal.EmptyArrays;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import lombok.val;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author MagicDroidX (Nukkit Project)
 */
@Log4j2
public class BinaryStream {

    public int offset;
    private byte[] buffer;
    protected int count;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public BinaryStream() {
        this.buffer = new byte[32];
        this.offset = 0;
        this.count = 0;
    }

    public BinaryStream(byte[] buffer) {
        this(buffer, 0);
    }

    public BinaryStream(byte[] buffer, int offset) {
        this.buffer = buffer;
        this.offset = offset;
        this.count = buffer.length;
    }

    public BinaryStream reset() {
        this.offset = 0;
        this.count = 0;
        return this;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
        this.count = buffer == null ? -1 : buffer.length;
    }

    public void setBuffer(byte[] buffer, int offset) {
        this.setBuffer(buffer);
        this.setOffset(offset);
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public byte[] getBuffer() {
        return Arrays.copyOf(buffer, count);
    }

    public int getCount() {
        return count;
    }

    public byte[] get() {
        return this.get(this.count - this.offset);
    }

    public byte[] get(int len) {
        if (len < 0) {
            this.offset = this.count - 1;
            return EmptyArrays.EMPTY_BYTES;
        }
        len = Math.min(len, this.getCount() - this.offset);
        this.offset += len;
        return Arrays.copyOfRange(this.buffer, this.offset - len, this.offset);
    }

    public void put(byte[] bytes) {
        if (bytes == null) {
            return;
        }

        this.ensureCapacity(this.count + bytes.length);

        System.arraycopy(bytes, 0, this.buffer, this.count, bytes.length);
        this.count += bytes.length;
    }

    public long getLong() {
        return Binary.readLong(this.get(8));
    }

    public void putLong(long l) {
        this.put(Binary.writeLong(l));
    }

    public int getInt() {
        return Binary.readInt(this.get(4));
    }

    public void putInt(int i) {
        this.put(Binary.writeInt(i));
    }

    public long getLLong() {
        return Binary.readLLong(this.get(8));
    }

    public void putLLong(long l) {
        this.put(Binary.writeLLong(l));
    }

    public int getLInt() {
        return Binary.readLInt(this.get(4));
    }

    public void putLInt(int i) {
        this.put(Binary.writeLInt(i));
    }

    public int getShort() {
        return Binary.readShort(this.get(2));
    }

    public void putShort(int s) {
        this.put(Binary.writeShort(s));
    }

    public int getLShort() {
        return Binary.readLShort(this.get(2));
    }

    public void putLShort(int s) {
        this.put(Binary.writeLShort(s));
    }

    public float getFloat() {
        return getFloat(-1);
    }

    public float getFloat(int accuracy) {
        return Binary.readFloat(this.get(4), accuracy);
    }

    public void putFloat(float v) {
        this.put(Binary.writeFloat(v));
    }

    public float getLFloat() {
        return getLFloat(-1);
    }

    public float getLFloat(int accuracy) {
        return Binary.readLFloat(this.get(4), accuracy);
    }

    public void putLFloat(float v) {
        this.put(Binary.writeLFloat(v));
    }

    public int getTriad() {
        return Binary.readTriad(this.get(3));
    }

    public void putTriad(int triad) {
        this.put(Binary.writeTriad(triad));
    }

    public int getLTriad() {
        return Binary.readLTriad(this.get(3));
    }

    public void putLTriad(int triad) {
        this.put(Binary.writeLTriad(triad));
    }

    public boolean getBoolean() {
        return this.getByte() == 0x01;
    }

    public void putBoolean(boolean bool) {
        this.putByte((byte) (bool ? 1 : 0));
    }

    public int getByte() {
        return this.buffer[this.offset++] & 0xff;
    }

    public void putByte(byte b) {
        this.put(new byte[]{b});
    }

    /**
     * Reads a list of Attributes from the stream.
     *
     * @return Attribute[]
     */
    public Attribute[] getAttributeList() throws Exception {
        List<Attribute> list = new ArrayList<>();
        long count = this.getUnsignedVarInt();

        for (int i = 0; i < count; ++i) {
            String name = this.getString();
            Attribute attr = Attribute.getAttributeByName(name);
            if (attr != null) {
                attr.setMinValue(this.getLFloat());
                attr.setValue(this.getLFloat());
                attr.setMaxValue(this.getLFloat());
                list.add(attr);
            } else {
                throw new Exception("Unknown attribute type \"" + name + "\"");
            }
        }

        return list.toArray(Attribute.EMPTY_ARRAY);
    }

    /**
     * Writes a list of Attributes to the packet buffer using the standard format.
     */
    public void putAttributeList(Attribute[] attributes) {
        this.putUnsignedVarInt(attributes.length);
        for (Attribute attribute : attributes) {
            this.putString(attribute.getName());
            this.putLFloat(attribute.getMinValue());
            this.putLFloat(attribute.getValue());
            this.putLFloat(attribute.getMaxValue());
        }
    }

    public void putUUID(UUID uuid) {
        this.put(Binary.writeUUID(uuid));
    }

    public UUID getUUID() {
        return Binary.readUUID(this.get(16));
    }

    public void putSkin(Skin skin, String gameVersion) {
        this.putString(skin.getSkinId());
        this.putString(skin.getPlayFabId());
        this.putString(skin.getSkinResourcePatch());
        this.putImage(skin.getSkinData());

        List<SkinAnimation> animations = skin.getAnimations();
        this.putLInt(animations.size());
        for (SkinAnimation animation : animations) {
            this.putImage(animation.image);
            this.putLInt(animation.type);
            this.putLFloat(animation.frames);
            this.putLInt(animation.expression);
        }

        this.putImage(skin.getCapeData());
        this.putString(skin.getGeometryData());
        this.putString(skin.getGeometryDataEngineVersion());
        this.putString(skin.getAnimationData());
        this.putString(skin.getCapeId());
        this.putString(skin.getFullSkinId());
        this.putString(skin.getArmSize());
        this.putString(skin.getSkinColor());
        List<PersonaPiece> pieces = skin.getPersonaPieces();
        this.putLInt(pieces.size());
        for (PersonaPiece piece : pieces) {
            this.putString(piece.id);
            this.putString(piece.type);
            this.putString(piece.packId);
            this.putBoolean(piece.isDefault);
            this.putString(piece.productId);
        }

        List<PersonaPieceTint> tints = skin.getTintColors();
        this.putLInt(tints.size());
        for (PersonaPieceTint tint : tints) {
            this.putString(tint.pieceType);
            List<String> colors = tint.colors;
            this.putLInt(colors.size());
            for (String color : colors) {
                this.putString(color);
            }
        }

        this.putBoolean(skin.isPremium());
        this.putBoolean(skin.isPersona());
        this.putBoolean(skin.isCapeOnClassic());
        this.putBoolean(skin.isPrimaryUser());

        if (gameVersion.equalsIgnoreCase("1.19.62")) {
            this.putBoolean(skin.isOverridingPlayerAppearance());
        }
    }

    public Skin getSkin(String gameVersion) {
        Skin skin = new Skin();
        skin.setSkinId(this.getString());
        skin.setPlayFabId(this.getString());
        skin.setSkinResourcePatch(this.getString());
        skin.setSkinData(this.getImage());

        int animationCount = this.getLInt();
        for (int i = 0; i < animationCount; i++) {
            SerializedImage image = this.getImage();
            int type = this.getLInt();
            float frames = this.getLFloat();
            int expression = this.getLInt();
            skin.getAnimations().add(new SkinAnimation(image, type, frames, expression));
        }

        skin.setCapeData(this.getImage());
        skin.setGeometryData(this.getString());
        skin.setGeometryDataEngineVersion(this.getString());
        skin.setAnimationData(this.getString());
        skin.setCapeId(this.getString());
        skin.setFullSkinId(this.getString());
        skin.setArmSize(this.getString());
        skin.setSkinColor(this.getString());

        int piecesLength = this.getLInt();
        for (int i = 0; i < piecesLength; i++) {
            String pieceId = this.getString();
            String pieceType = this.getString();
            String packId = this.getString();
            boolean isDefault = this.getBoolean();
            String productId = this.getString();
            skin.getPersonaPieces().add(new PersonaPiece(pieceId, pieceType, packId, isDefault, productId));
        }

        int tintsLength = this.getLInt();
        for (int i = 0; i < tintsLength; i++) {
            String pieceType = this.getString();
            List<String> colors = new ArrayList<>();
            int colorsLength = this.getLInt();
            for (int i2 = 0; i2 < colorsLength; i2++) {
                colors.add(this.getString());
            }
            skin.getTintColors().add(new PersonaPieceTint(pieceType, colors));
        }

        skin.setPremium(this.getBoolean());
        skin.setPersona(this.getBoolean());
        skin.setCapeOnClassic(this.getBoolean());
        skin.setPrimaryUser(this.getBoolean());

        if (gameVersion.equalsIgnoreCase("1.19.62")) {
            skin.setOverridingPlayerAppearance(this.getBoolean());
        }

        return skin;
    }

    public void putImage(SerializedImage image) {
        this.putLInt(image.width);
        this.putLInt(image.height);
        this.putByteArray(image.data);
    }

    public SerializedImage getImage() {
        int width = this.getLInt();
        int height = this.getLInt();
        byte[] data = this.getByteArray();
        return new SerializedImage(width, height, data);
    }

    public Item getSlot(int protocol) {
        return this.getSlot(protocol, false);
    }

    public Item getSlot(int protocol, boolean instanceItem) {
        int networkId = this.getVarInt();
        if (networkId == 0) {
            return Item.get(ItemID.AIR, 0, 0);
        }

        int count = this.getLShort();
        int damage = (int) this.getUnsignedVarInt();

        if (!instanceItem) {
            final boolean hasNetId = this.getBoolean();

            int stackNetworkId = 0;

            if (hasNetId) {
                stackNetworkId = this.getVarInt();
            }
        }

        final ItemID id = ItemID.byNetworkId(BedrockMappingUtil.translateItemRuntimeId(protocol, networkId, false));

        int blockRuntimeId = BedrockMappingUtil.translateBlockRuntimeId(protocol, this.getVarInt(), false);

        byte[] bytes = this.getByteArray();
        ByteBuf buf = AbstractByteBufAllocator.DEFAULT.ioBuffer(bytes.length);
        buf.writeBytes(bytes);

        byte[] nbt = new byte[0];
        String[] canPlace;
        String[] canBreak;

        try (LittleEndianByteBufInputStream stream = new LittleEndianByteBufInputStream(buf)) {
            int nbtSize = stream.readShort();

            CompoundTag compoundTag = null;
            if (nbtSize > 0) {
                compoundTag = NBTIO.read(stream, ByteOrder.LITTLE_ENDIAN);
            } else if (nbtSize == -1) {
                int tagCount = stream.readUnsignedByte();
                if (tagCount != 1) throw new IllegalArgumentException("Expected 1 tag but got " + tagCount);
                compoundTag = NBTIO.read(stream, ByteOrder.LITTLE_ENDIAN);
            }

            if (compoundTag != null && compoundTag.getAllTags().size() > 0) {
                if (compoundTag.contains("Damage")) {
                    damage = compoundTag.getInt("Damage");
                    compoundTag.remove("Damage");
                }
                if (compoundTag.contains("__DamageConflict__")) {
                    compoundTag.put("Damage", compoundTag.removeAndGet("__DamageConflict__"));
                }
                if (!compoundTag.isEmpty()) {
                    nbt = NBTIO.write(compoundTag, ByteOrder.LITTLE_ENDIAN);
                }
            }

            canPlace = new String[stream.readInt()];
            for (int i = 0; i < canPlace.length; i++) {
                canPlace[i] = stream.readUTF();
            }

            canBreak = new String[stream.readInt()];
            for (int i = 0; i < canBreak.length; i++) {
                canBreak[i] = stream.readUTF();
            }

            if (id == ItemID.SHIELD) {
                stream.readLong();
            }
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read item user data", e);
        } finally {
            buf.release();
        }

        Item item = Item.get(id, damage, count, nbt);
        item.setStackNetworkId(Item.stackNetworkIdCount++);
        item.setBlockRuntimeId(blockRuntimeId);

        if (canBreak.length > 0 || canPlace.length > 0) {
            CompoundTag namedTag = item.getNamedTag();
            if (namedTag == null) {
                namedTag = new CompoundTag();
            }

            if (canBreak.length > 0) {
                ListTag<StringTag> listTag = new ListTag<>("CanDestroy");
                for (String blockName : canBreak) {
                    listTag.add(new StringTag("", blockName));
                }
                namedTag.put("CanDestroy", listTag);
            }

            if (canPlace.length > 0) {
                ListTag<StringTag> listTag = new ListTag<>("CanPlaceOn");
                for (String blockName : canPlace) {
                    listTag.add(new StringTag("", blockName));
                }
                namedTag.put("CanPlaceOn", listTag);
            }

            item.setNamedTag(namedTag);
        }

        return item;
    }

    public void putSlot(Item item, int protocol) {
        this.putSlot(item, protocol, false);
    }

    @Since("1.4.0.0-PN")
    public void putSlot(Item item, int protocol, boolean instanceItem) {
        if (item == null || item.getIdentifier() == ItemID.AIR) {
            putByte((byte) 0);
            return;
        }

        int networkId = BedrockMappingUtil.translateItemRuntimeId(protocol, item.getIdentifier().getNetworkId(), true);

        putVarInt(networkId);
        putLShort(item.getCount());

        int meta = 0;

        if (item.getBlockRuntimeId() == 0 || item.getBlock() == null) {
            meta = item.getDamage();
        }

        putUnsignedVarInt(meta);

        if (!instanceItem) {
            putBoolean(true); // hasNetId
            putVarInt(networkId); // netId
        }

        Block block = item.getBlockUnsafe();

        if (block != null) {
            block.setDamage(item.getDamage());
        }

        int blockRuntimeId = block == null ? (item.getBlockRuntimeId() > 0 ? BedrockMappingUtil.translateBlockRuntimeId(protocol, item.getBlockRuntimeId(), true) : 0) : BedrockMappingUtil.translateBlockRuntimeId(protocol, block.getRuntimeId(), true);
        putVarInt(blockRuntimeId);

        if (item.getBlockRuntimeId() > 0 || item.getBlock() != null) {
            meta = item.getDamage();
        }

        ByteBuf userDataBuf = ByteBufAllocator.DEFAULT.ioBuffer();
        try (LittleEndianByteBufOutputStream stream = new LittleEndianByteBufOutputStream(userDataBuf)) {
            if (meta != 0) {
                byte[] nbt = item.getCompoundTag();
                CompoundTag tag;
                if (nbt == null || nbt.length == 0) {
                    tag = new CompoundTag();
                } else {
                    tag = NBTIO.read(nbt, ByteOrder.LITTLE_ENDIAN);
                }
                if (tag.contains("Damage")) {
                    tag.put("__DamageConflict__", tag.removeAndGet("Damage"));
                }
                tag.putInt("Damage", meta);
                stream.writeShort(-1);
                stream.writeByte(1); // Hardcoded in current version
                stream.write(NBTIO.write(tag, ByteOrder.LITTLE_ENDIAN));
            } else if (item.hasCompoundTag()) {
                stream.writeShort(-1);
                stream.writeByte(1); // Hardcoded in current version
                stream.write(item.getCompoundTag());
            } else {
                userDataBuf.writeShortLE(0);
            }

            List<String> canPlaceOn = extractStringList(item, "CanPlaceOn");
            stream.writeInt(canPlaceOn.size());
            for (String string : canPlaceOn) {
                stream.writeUTF(string);
            }

            List<String> canDestroy = extractStringList(item, "CanDestroy");
            stream.writeInt(canDestroy.size());
            for (String string : canDestroy) {
                stream.writeUTF(string);
            }

            if (item.getIdentifier() == ItemID.SHIELD) {
                stream.writeLong(0);
            }

            byte[] bytes = new byte[userDataBuf.readableBytes()];
            userDataBuf.readBytes(bytes);
            putByteArray(bytes);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to write item user data", e);
        } finally {
            userDataBuf.release();
        }
    }

    public Item getRecipeIngredient() {
        int networkId = this.getVarInt();
        if (networkId == 0) {
            return Item.get(ItemID.AIR, 0, 0);
        }

        ItemID id = ItemID.byNetworkId(networkId);

        int damage = this.getVarInt();
        int count = this.getVarInt();

        return Item.get(id, damage, count);
    }

    public void putRecipeIngredient(Item ingredient, int protocol) {
        if (ingredient == null || ingredient.getIdentifier().equals(ItemID.AIR)) {
            this.putBoolean(false); // isValid? - false
            this.putVarInt(0); // item == null ? 0 : item.getCount()
            return;
        }

        this.putBoolean(true); // isValid? - true

        int networkId = ingredient.getIdentifier().getNetworkId();
        int damage = ingredient.hasMeta() ? ingredient.getDamage() : 0x7fff;

        this.putLShort(networkId);
        this.putLShort(damage);
        this.putVarInt(ingredient.getCount());
    }

    private List<String> extractStringList(Item item, String tagName) {
        CompoundTag namedTag = item.getNamedTag();
        if (namedTag == null) {
            return Collections.emptyList();
        }

        ListTag<StringTag> listTag = namedTag.getList(tagName, StringTag.class);
        if (listTag == null) {
            return Collections.emptyList();
        }

        int size = listTag.size();
        List<String> values = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            StringTag stringTag = listTag.get(i);
            if (stringTag != null) {
                values.add(stringTag.data);
            }
        }

        return values;
    }

    public byte[] getByteArray() {
        return this.get((int) this.getUnsignedVarInt());
    }

    public void putByteArray(byte[] b) {
        this.putUnsignedVarInt(b.length);
        this.put(b);
    }

    public String getString() {
        return new String(this.getByteArray(), StandardCharsets.UTF_8);
    }

    public void putString(String string) {
        byte[] b = string.getBytes(StandardCharsets.UTF_8);
        this.putByteArray(b);
    }

    public long getUnsignedVarInt() {
        return VarInt.readUnsignedVarInt(this);
    }

    public void putUnsignedVarInt(long v) {
        VarInt.writeUnsignedVarInt(this, v);
    }

    public int getVarInt() {
        return VarInt.readVarInt(this);
    }

    public void putVarInt(int v) {
        VarInt.writeVarInt(this, v);
    }

    public long getVarLong() {
        return VarInt.readVarLong(this);
    }

    public void putVarLong(long v) {
        VarInt.writeVarLong(this, v);
    }

    public long getUnsignedVarLong() {
        return VarInt.readUnsignedVarLong(this);
    }

    public void putUnsignedVarLong(long v) {
        VarInt.writeUnsignedVarLong(this, v);
    }

    public BlockVector3 getBlockVector3() {
        return new BlockVector3(this.getVarInt(), (int) this.getUnsignedVarInt(), this.getVarInt());
    }

    public BlockVector3 getSignedBlockPosition() {
        return new BlockVector3(getVarInt(), getVarInt(), getVarInt());
    }

    public void putSignedBlockPosition(BlockVector3 v) {
        putVarInt(v.x);
        putVarInt(v.y);
        putVarInt(v.z);
    }

    public void putBlockVector3(BlockVector3 v) {
        this.putBlockVector3(v.x, v.y, v.z);
    }

    public void putBlockVector3(int x, int y, int z) {
        this.putVarInt(x);
        this.putUnsignedVarInt(y);
        this.putVarInt(z);
    }

    public Vector3f getVector3f() {
        return new Vector3f(this.getLFloat(4), this.getLFloat(4), this.getLFloat(4));
    }

    public void putVector3f(Vector3f v) {
        this.putVector3f(v.x, v.y, v.z);
    }

    public void putVector3f(float x, float y, float z) {
        this.putLFloat(x);
        this.putLFloat(y);
        this.putLFloat(z);
    }

    public void putGameRules(GameRules gameRules) {
        // LinkedHashMap gives mutability and is faster in iteration
        val rules = new LinkedHashMap<>(gameRules.getGameRules());
        rules.keySet().removeIf(GameRule::isDeprecated);

        this.putUnsignedVarInt(rules.size());
        rules.forEach((gameRule, value) -> {
            this.putString(gameRule.getName().toLowerCase());
            value.write(this);
        });
    }

    /**
     * Reads and returns an EntityUniqueID
     *
     * @return int
     */
    public long getEntityUniqueId() {
        return this.getVarLong();
    }

    /**
     * Writes an EntityUniqueID
     */
    public void putEntityUniqueId(long eid) {
        this.putVarLong(eid);
    }

    /**
     * Reads and returns an EntityRuntimeID
     */
    public long getEntityRuntimeId() {
        return this.getUnsignedVarLong();
    }

    /**
     * Writes an EntityUniqueID
     */
    public void putEntityRuntimeId(long eid) {
        this.putUnsignedVarLong(eid);
    }

    public BlockFace getBlockFace() {
        return BlockFace.fromIndex(this.getVarInt());
    }

    public void putBlockFace(BlockFace face) {
        this.putVarInt(face.getIndex());
    }

    public void putEntityLink(EntityLink link) {
        putEntityUniqueId(link.fromEntityUniquieId);
        putEntityUniqueId(link.toEntityUniquieId);
        putByte(link.type);
        putBoolean(link.immediate);
        putBoolean(link.riderInitiated);
    }

    public EntityLink getEntityLink() {
        return new EntityLink(
                getEntityUniqueId(),
                getEntityUniqueId(),
                (byte) getByte(),
                getBoolean(),
                getBoolean()
        );
    }

    public void putPlayerAbilities(PlayerAbilityHolder abilityHolder) {
        this.putLLong(abilityHolder.getUniqueEntityId());
        this.putByte((byte) abilityHolder.getPlayerPermission());
        this.putByte((byte) abilityHolder.getCommandPermission());

        this.putUnsignedVarInt(abilityHolder.getAbilityLayers().size());

        for (AbilityLayer abilityLayer : abilityHolder.getAbilityLayers()) {
            this.putLShort(abilityLayer.getLayerType().ordinal());
            this.putLInt(this.getAbilitiesNumber(abilityLayer.getAbilitiesSet()));
            this.putLInt(this.getAbilitiesNumber(abilityLayer.getAbilityValues()));
            this.putLFloat(abilityLayer.getFlySpeed());
            this.putLFloat(abilityLayer.getWalkSpeed());
        }
    }

    public void getPlayerAbilities(PlayerAbilityHolder abilityHolder) {
        abilityHolder.setUniqueEntityId(this.getLLong());
        abilityHolder.setPlayerPermission(this.getByte());
        abilityHolder.setCommandPermission(this.getByte());

        final List<AbilityLayer> abilityLayers = new ObjectArrayList<>();
        final int size = (int) this.getUnsignedVarInt();

        for (int i = 0; i < size; i++) {
            final AbilityLayer abilityLayer = new AbilityLayer();
            abilityLayer.setLayerType(AbilityLayer.Type.values()[this.getLShort()]);

            this.readAbilitiesByNumber(this.getLInt(), abilityLayer.getAbilitiesSet());
            this.readAbilitiesByNumber(this.getLInt(), abilityLayer.getAbilityValues());

            abilityLayer.setFlySpeed(this.getLFloat());
            abilityLayer.setWalkSpeed(this.getLFloat());
        }

        abilityHolder.setAbilityLayers(abilityLayers);
    }

    private int getAbilitiesNumber(Set<Ability> abilities) {
        int number = 0;

        for (Ability ability : abilities) {
            number |= 1 << ability.ordinal();
        }

        return number;
    }

    private void readAbilitiesByNumber(int number, Set<Ability> abilities) {
        for (Ability ability : abilities) {
            if ((number & (1 << ability.ordinal())) != 0) {
                abilities.add(ability);
            }
        }
    }

    public void putStructureSettings(StructureSettings settings) {
        this.putString(settings.getPaletteName());
        this.putBoolean(settings.isIgnoringBlocks());
        this.putBoolean(settings.isIgnoringEntities());
        this.putBoolean(settings.isNonTickingPlayersAndTickingAreasEnabled());
        this.putBlockVector3(settings.getSize());
        this.putBlockVector3(settings.getOffset());
        this.putUnsignedVarLong(settings.getLastEditedByEntityId());
        this.putByte((byte) settings.getRotation().ordinal());
        this.putByte((byte) settings.getMirror().ordinal());
        this.putByte((byte) settings.getAnimationMode().ordinal());
        this.putLFloat(settings.getAnimationSeconds());
        this.putLFloat(settings.getIntegrityValue());
        this.putLInt(settings.getIntegritySeed());
        this.putVector3f(settings.getPivot());
    }

    public StructureSettings getStructureSettings() {
        final String paletteName = this.getString();
        final boolean ignoringBlocks = this.getBoolean();
        final boolean ignoringEntities = this.getBoolean();
        final boolean nonTickingPlayersAndTickingAreasEnabled = this.getBoolean();
        final BlockVector3 size = this.getBlockVector3();
        final BlockVector3 offset = this.getBlockVector3();
        final long lastEditedByEntityId = this.getUnsignedVarLong();
        final StructureRotation rotation = StructureRotation.values()[this.getByte()];
        final StructureMirror mirror = StructureMirror.values()[this.getByte()];
        final StructureAnimationMode animationMode = StructureAnimationMode.values()[this.getByte()];
        final float animationSeconds = this.getLFloat();
        final float integrityValue = this.getLFloat();
        final int integritySeed = this.getLInt();
        final Vector3f pivot = this.getVector3f();

        return new StructureSettings(paletteName, ignoringBlocks, ignoringEntities, nonTickingPlayersAndTickingAreasEnabled, size, offset, lastEditedByEntityId, rotation, mirror, animationMode, animationSeconds, integrityValue, integritySeed, pivot);
    }

    public void putCommandOrigin(CommandOriginData commandOriginData) {
        this.putUnsignedVarInt(commandOriginData.getType().ordinal());
        this.putUUID(commandOriginData.getUuid());
        this.putString(commandOriginData.getRequestId());
        this.putUnsignedVarLong(commandOriginData.getEntityUniqueId());
    }

    public CommandOriginData getCommandOrigin() {
        final CommandOriginType type = CommandOriginType.values()[(int) this.getUnsignedVarInt()];
        final UUID uuid = this.getUUID();
        final String requestId = this.getString();
        final long entityUniqueId = this.getUnsignedVarLong();

        return new CommandOriginData(type, uuid, requestId, entityUniqueId);
    }

    public Transaction getTransaction(int protocol) {
        final int legacyRequestId = this.getVarInt();
        final List<LegacyTransaction> legacyTransactions = new ObjectArrayList<>();

        if (legacyRequestId != 0) {
            final int legacyTransactionLength = (int) this.getUnsignedVarInt();

            for (int i = 0; i < legacyTransactionLength; i++) {
                final byte containerId = (byte) this.getByte();
                final byte[] slots = this.getByteArray();

                legacyTransactions.add(new LegacyTransaction(containerId, slots));
            }
        }

        final TransactionLegacy transactionLegacy = new TransactionLegacy(legacyRequestId, legacyTransactions);

        final int transactionActionsLength = this.getVarInt();
        final List<TransactionAction> transactionActions = new ObjectArrayList<>();

        for (int i = 0; i < transactionActionsLength; i++) {
            final TransactionActionSourceType sourceType = TransactionActionSourceType.byId(this.getVarInt());

            if (sourceType == null) {
                continue;
            }

            WindowIDVarInt inventoryId = null;
            int flags = -1;
            int action = -1;

            if (sourceType.equals(TransactionActionSourceType.CONTAINER) || sourceType.equals(TransactionActionSourceType.CRAFT)) {
                inventoryId = WindowIDVarInt.byId(this.getVarInt());
            }

            if (sourceType.equals(TransactionActionSourceType.WORLD_INTERACTION)) {
                flags = this.getVarInt();
            }

            if (sourceType.equals(TransactionActionSourceType.CRAFT_SLOT) || sourceType.equals(TransactionActionSourceType.CRAFT)) {
                action = this.getVarInt();
            }

            final int slot = this.getVarInt();
            final Item oldItem = this.getSlot(protocol);
            final Item newItem = this.getSlot(protocol);

            transactionActions.add(new TransactionAction(sourceType, inventoryId, flags, action, slot, oldItem, newItem));
        }

        final TransactionUseItemActionType useItemActionType = TransactionUseItemActionType.values()[this.getVarInt()];
        final BlockVector3 blockPosition = this.getBlockVector3();
        final int face = this.getVarInt();
        final int hotbarSlot = this.getVarInt();
        final Item heldItem = this.getSlot(protocol);
        final Vector3f playerPos = this.getVector3f();
        final Vector3f clickPos = this.getVector3f();
        final int blockRuntimeId = (int) this.getUnsignedVarInt();

        final TransactionUseItem transactionUseItem = new TransactionUseItem(useItemActionType, blockPosition, face, hotbarSlot, heldItem, playerPos, clickPos, blockRuntimeId);

        return new Transaction(transactionLegacy, transactionActions, transactionUseItem);
    }

    public ItemStackRequest getItemStackRequest(int protocol) {
        final int requestId = this.getVarInt();
        final int actionsLength = (int) this.getUnsignedVarInt();

        final List<ItemStackRequestAction> actions = new ObjectArrayList<>();

        for (int i = 0; i < actionsLength; i++) {
            final ItemStackRequestActionType actionType = ItemStackRequestActionType.values()[this.getByte()];

            switch (actionType) {
                case TAKE:
                    actions.add(new TakeAction((byte) this.getByte(), this.getStackRequestSlotInfo(protocol), this.getStackRequestSlotInfo(protocol)));

                    break;
                case PLACE:
                    actions.add(new PlaceAction((byte) this.getByte(), this.getStackRequestSlotInfo(protocol), this.getStackRequestSlotInfo(protocol)));

                    break;
                case SWAP:
                    actions.add(new SwapAction(this.getStackRequestSlotInfo(protocol), this.getStackRequestSlotInfo(protocol)));

                    break;
                case DROP:
                    actions.add(new DropAction((byte) this.getByte(), this.getStackRequestSlotInfo(protocol), this.getBoolean()));

                    break;
                case DESTROY:
                    actions.add(new DestroyAction((byte) this.getByte(), this.getStackRequestSlotInfo(protocol)));

                    break;
                case CONSUME:
                    actions.add(new ConsumeAction((byte) this.getByte(), this.getStackRequestSlotInfo(protocol)));

                    break;
                case CREATE:
                    actions.add(new CreateAction((byte) this.getByte()));

                    break;
                case LAB_TABLE_COMBINE:
                    actions.add(new LabTableCombineAction());

                    break;
                case BEACON_PAYMENT:
                    actions.add(new BeaconPaymentAction(this.getVarInt(), this.getVarInt()));

                    break;
                case MINE_BLOCK:
                    actions.add(new MineBlockAction(this.getVarInt(), this.getVarInt(), this.getVarInt()));

                    break;
                case CRAFT_RECIPE:
                    actions.add(new CraftRecipeAction((int) this.getUnsignedVarInt()));

                    break;
                case CRAFT_RECIPE_AUTO:
                    final int recipeNetworkId = (int) this.getUnsignedVarInt();
                    final byte timesCrafted = (byte) this.getByte();
                    final List<Item> resultItems = new ObjectArrayList<>();

                    if (protocol >= Protocol.V1_19_40.version()) {
                        final int length = (int) this.getUnsignedVarInt();

                        for (int j = 0; j < length; j++) {
                            final int networkId = this.getLShort();

                            final Item item = Item.get(ItemID.byNetworkId(networkId));

                            if (networkId != 0) {
                                item.setDamage(this.getLShort());
                            }

                            item.setCount(this.getLShort());

                            resultItems.add(item);
                        }
                    }

                    actions.add(new CraftRecipeAutoAction(recipeNetworkId, timesCrafted, resultItems.toArray(Item.EMPTY_ARRAY)));

                    break;
                case CRAFT_CREATIVE:
                    actions.add(new CraftCreativeAction((int) this.getUnsignedVarInt()));

                    break;
                case CRAFT_RECIPE_OPTIONAL:
                    actions.add(new CraftRecipeOptionalAction((int) this.getUnsignedVarInt(), this.getLInt()));

                    break;
                case CRAFT_REPAIR_AND_DISENCHANT:
                    actions.add(new CraftRepairAndDisenchantAction((int) this.getUnsignedVarInt(), this.getVarInt()));

                    break;
                case CRAFT_LOOM:
                    actions.add(new CraftLoomAction(this.getString()));

                    break;
                case CRAFT_RESULTS_DEPRECATED:
                    final int length = (int) this.getUnsignedVarInt();
                    final List<Item> items = new ObjectArrayList<>();

                    for (int j = 0; j < length; j++) {
                        items.add(this.getSlot(protocol, true));
                    }

                    actions.add(new CraftResultsDeprecatedAction(items.toArray(Item.EMPTY_ARRAY), (byte) this.getByte()));

                    break;
                case PLACE_IN_ITEM_CONTAINER:
                case TAKE_FROM_ITEM_CONTAINER:
                case CRAFT_NON_IMPLEMENTED_DEPRECATED:
                    break;
            }
        }

        final int filtersLength = (int) this.getUnsignedVarInt();

        final List<String> filters = new ObjectArrayList<>();

        for (int i = 0; i < filtersLength; i++) {
            filters.add(this.getString());
        }

        final int val = this.getLInt();
        final ItemStackRequestFilterCause filterCause = val < 0 ? null : ItemStackRequestFilterCause.values()[val];

        return new ItemStackRequest(requestId, actions, filters, filterCause);
    }

    public StackRequestSlotInfo getStackRequestSlotInfo(int protocol) {
        return new StackRequestSlotInfo(ContainerSlotType.values()[BedrockMappingUtil.translateContainerSlotType(protocol, this.getByte())], (byte) this.getByte(), this.getVarInt());
    }

    public void putItemStackResponse(ItemStackResponse itemStackResponse) {
        this.putByte((byte) itemStackResponse.getStatus().ordinal());
        this.putVarInt(itemStackResponse.getRequestId());

        if (itemStackResponse.getStatus().equals(ItemStackResponseStatus.OK)) {
            this.putUnsignedVarInt(itemStackResponse.getContainers().size());

            for (ItemStackResponseContainerInfo container : itemStackResponse.getContainers()) {
                this.putByte((byte) container.getSlotType().ordinal());
                this.putUnsignedVarInt(container.getSlots().size());

                for (ContainerSlot slot : container.getSlots()) {
                    this.putByte(slot.getSlot());
                    this.putByte(slot.getHotbarSlot());
                    this.putByte(slot.getCount());
                    this.putVarInt(slot.getStackNetworkId());
                    this.putString(slot.getCustomName());
                    this.putVarInt(slot.getDurability());
                }
            }
        }
    }

    public void putEntityProperties(EntityProperties entityProperties) {
        this.putUnsignedVarInt(entityProperties.getIntProperties().size());

        for (IntEntityProperty intProperty : entityProperties.getIntProperties()) {
            this.putUnsignedVarInt(intProperty.getIndex());
            this.putVarInt(intProperty.getValue());
        }

        this.putUnsignedVarInt(entityProperties.getFloatProperties().size());

        for (FloatEntityProperty floatProperty : entityProperties.getFloatProperties()) {
            this.putUnsignedVarInt(floatProperty.getIndex());
            this.putLFloat(floatProperty.getValue());
        }
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public <T> void putArray(Collection<T> collection, Consumer<T> writer) {
        if (collection == null) {
            putUnsignedVarInt(0);
            return;
        }
        putUnsignedVarInt(collection.size());
        collection.forEach(writer);
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public <T> void putArray(T[] collection, Consumer<T> writer) {
        if (collection == null) {
            putUnsignedVarInt(0);
            return;
        }
        putUnsignedVarInt(collection.length);
        for (T t : collection) {
            writer.accept(t);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> T[] getArray(Class<T> clazz, Function<BinaryStream, T> function) {
        ArrayDeque<T> deque = new ArrayDeque<>();
        int count = (int) getUnsignedVarInt();
        for (int i = 0; i < count; i++) {
            deque.add(function.apply(this));
        }
        return deque.toArray((T[]) Array.newInstance(clazz, 0));
    }

    public boolean feof() {
        return this.offset < 0 || this.offset >= this.buffer.length;
    }

    @SneakyThrows(IOException.class)
    @PowerNukkitOnly
    @Since("1.5.0.0-PN")
    public CompoundTag getTag() {
        ByteArrayInputStream is = new ByteArrayInputStream(buffer, offset, buffer.length);
        int initial = is.available();
        try {
            return NBTIO.read(is);
        } finally {
            offset += initial - is.available();
        }
    }

    @SneakyThrows(IOException.class)
    @PowerNukkitOnly
    @Since("1.5.0.0-PN")
    public void putTag(CompoundTag tag) {
        put(NBTIO.write(tag));
    }

    private void ensureCapacity(int minCapacity) {
        // overflow-conscious code
        if (minCapacity - buffer.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = buffer.length;
        int newCapacity = oldCapacity << 1;

        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }

        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        this.buffer = Arrays.copyOf(buffer, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) { // overflow
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }
}
