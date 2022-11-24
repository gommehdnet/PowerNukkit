package cn.nukkit.item;

import cn.nukkit.Player;
import cn.nukkit.api.*;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.blockproperty.value.CoralType;
import cn.nukkit.blockstate.BlockStateRegistry;
import cn.nukkit.entity.Entity;
import cn.nukkit.inventory.Fuel;
import cn.nukkit.item.enchantment.Enchantment;
import cn.nukkit.item.enchantment.sideeffect.SideEffect;
import cn.nukkit.level.Level;
import cn.nukkit.math.BlockFace;
import cn.nukkit.math.Vector3;
import cn.nukkit.nbt.NBTIO;
import cn.nukkit.nbt.tag.*;
import cn.nukkit.network.protocol.Protocol;
import cn.nukkit.utils.BedrockResourceUtil;
import cn.nukkit.utils.Binary;
import cn.nukkit.utils.Config;
import io.netty.util.internal.EmptyArrays;
import it.unimi.dsi.fastutil.ints.Int2IntArrayMap;
import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.ByteOrder;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author MagicDroidX (Nukkit Project)
 */
@Log4j2
public class Item implements Cloneable {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static final Item[] EMPTY_ARRAY = new Item[0];

    /**
     * Groups:
     * <ol>
     *     <li>namespace (optional)</li>
     *     <li>item name (choice)</li>
     *     <li>damage (optional, for item name)</li>
     *     <li>numeric id (choice)</li>
     *     <li>damage (optional, for numeric id)</li>
     * </ol>
     */
    private static final Pattern ITEM_STRING_PATTERN = Pattern.compile(
            //       1:namespace    2:name           3:damage   4:num-id    5:damage
            "^(?:(?:([a-z_]\\w*):)?([a-z._]\\w*)(?::(-?\\d+))?|(-?\\d+)(?::(-?\\d+))?)$");

    protected static String UNKNOWN_STR = "Unknown";

    private static Map<String, Integer> itemIds = Arrays.stream(ItemID.class.getDeclaredFields())
            .filter(field -> field.getModifiers() == (Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL))
            .filter(field -> field.getType().equals(int.class))
            .collect(Collectors.toMap(
                    field -> field.getName().toLowerCase(),
                    field -> {
                        try {
                            return field.getInt(null);
                        } catch (IllegalAccessException e) {
                            throw new InternalError(e);
                        }
                    },
                    (e1, e2) -> e1, LinkedHashMap::new
            ));

    private static Map<String, Integer> blockIds = Arrays.stream(BlockID.class.getDeclaredFields())
            .filter(field -> field.getModifiers() == (Modifier.PUBLIC | Modifier.STATIC | Modifier.FINAL))
            .filter(field -> field.getType().equals(int.class))
            .collect(Collectors.toMap(
                    field -> field.getName().toLowerCase(),
                    field -> {
                        try {
                            int blockId = field.getInt(null);
                            if (blockId > 255) {
                                return 255 - blockId;
                            }
                            return blockId;
                        } catch (IllegalAccessException e) {
                            throw new InternalError(e);
                        }
                    },
                    (e1, e2) -> e1, LinkedHashMap::new
            ));

    protected Block block = null;
    protected final ItemID identifier;
    protected int meta;
    protected boolean hasMeta = true;
    private byte[] tags = EmptyArrays.EMPTY_BYTES;
    private transient CompoundTag cachedNBT = null;
    public int count;

    @Getter
    @Setter
    private int blockRuntimeId = 0;

    @Getter
    @Setter
    private int stackNetworkId = 0;

    public static int stackNetworkIdCount = 0;

    @Deprecated
    @DeprecationDetails(since = "1.4.0.0-PN", by = "PowerNukkit", reason = "Unused", replaceWith = "meta or getDamage()")
    protected int durability = 0;

    protected String name;

    public Item(ItemID identifier) {
        this(identifier, 0);
    }

    public Item(ItemID identifier, int meta) {
        this(identifier, meta, 1);
    }

    public Item(ItemID identifier, int meta, int count) {
        this(identifier, meta, count, UNKNOWN_STR);
    }

    public Item(ItemID identifier, int meta, int count, String name) {
        this.identifier = identifier;
        this.meta = meta;
        this.count = count;
        this.name = name != null ? name.intern() : null;
    }

    public boolean hasMeta() {
        return hasMeta;
    }

    public boolean canBeActivated() {
        return false;
    }

    public static void init() {
        initCreativeItems();
    }

    private static List<String> itemList;

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static List<String> rebuildItemList() {
        return itemList = Collections.unmodifiableList(Stream.of(
                Arrays.stream(BlockID.values())
                        .map(name -> name.getIdentifier().substring(name.getIdentifier().indexOf(':') + 1)),
                itemIds.keySet().stream()
        ).flatMap(Function.identity()).distinct().collect(Collectors.toList()));
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static List<String> getItemList() {
        List<String> itemList = Item.itemList;
        if (itemList == null) {
            return rebuildItemList();
        }
        return itemList;
    }

    private static final Int2ObjectMap<ArrayList<Item>> creative = new Int2ObjectOpenHashMap<>();

    @SneakyThrows(IOException.class)
    @SuppressWarnings("unchecked")
    private static void initCreativeItems() {
        clearCreativeItems();

        Config config = new Config(Config.JSON);

        for (Protocol protocol : Protocol.VALUES) {
            if (!protocol.equals(Protocol.UNKNOWN)) {
                int protocolVersion = protocol.version();

                Item.creative.put(protocolVersion, new ArrayList<>());
                Item.metaIds.put(protocolVersion, new HashMap<>());

                try (InputStream resourceAsStream = BedrockResourceUtil.creativeItemsInput(protocolVersion)) {
                    config.load(resourceAsStream);
                }

                List<Map> list = config.getMapList("items");

                for (Map map : list) {
                    try {
                        Item item = loadCreativeItemEntry(map, protocolVersion);

                        if (item != null) {
                            addCreativeItem(item, protocolVersion);
                        }
                    } catch (Exception e) {
                        log.error("Error while registering a creative item", e);
                    }
                }
            }
        }
    }

    private static final Int2ObjectMap<Map<String, Integer>> metaIds = new Int2ObjectOpenHashMap<>();

    private static Item loadCreativeItemEntry(Map<String, Object> data, int protocol) {
        final String id = (String) data.get("id");

        final ItemID itemID = ItemID.byIdentifier(id);
        Item item = Item.get(itemID);

        if (data.containsKey("damage")) {
            item.setDamage(((Number) data.get("damage")).intValue());
        }

        if (data.containsKey("nbt_b64")) {
            item.setCompoundTag(Base64.getDecoder().decode((String) data.get("nbt_b64")));
        }

        if (data.containsKey("block_state_b64")) {
            final CompoundTag compoundTag = parseCompoundTag(Base64.getDecoder().decode((String) data.get("block_state_b64")));
            final int blockRuntimeId = BlockStateRegistry.getRuntimeIdByStates(compoundTag);
            int meta = Item.metaIds.get(protocol).getOrDefault(id, 0);

            if ((id.equalsIgnoreCase("minecraft:coral") || id.equalsIgnoreCase("minecraft:coral_block")) && meta >= CoralType.values().length) {
                Item.metaIds.get(protocol).put(id, 0);

                meta = 0;
            }

            item.setBlockRuntimeId(blockRuntimeId);
            item.setDamage(meta);
        }

        Item.metaIds.get(protocol).put(id, Item.metaIds.get(protocol).getOrDefault(id, 0) + 1);

        return item;
    }

    public static void clearCreativeItems() {
        Item.creative.clear();
    }

    public static ArrayList<Item> getCreativeItems(int protocol) {
        return new ArrayList<>(Item.creative.get(protocol));
    }

    public static void addCreativeItem(Item item, int protocol) {
        Item.creative.get(protocol).add(item.clone());
    }

    public static void removeCreativeItem(Item item, int protocol) {
        int index = getCreativeItemIndex(item, protocol);
        if (index != -1) {
            Item.creative.get(protocol).remove(index);
        }
    }

    public static boolean isCreativeItem(Item item, int protocol) {
        for (Item aCreative : Item.creative.get(protocol)) {
            if (item.equals(aCreative, !item.isTool())) {
                return true;
            }
        }
        return false;
    }

    public static Item getCreativeItem(int index, int protocol) {
        return (index >= 0 && index < Item.creative.get(protocol).size()) ? Item.creative.get(protocol).get(index) : null;
    }

    public static int getCreativeItemIndex(Item item, int protocol) {
        for (int i = 0; i < Item.creative.get(protocol).size(); i++) {
            if (item.equals(Item.creative.get(protocol).get(i), !item.isTool())) {
                return i;
            }
        }
        return -1;
    }

    public static Item get(ItemID identifier) {
        if (identifier.getIdentifier().equalsIgnoreCase(ItemID.AIR.getIdentifier())) {
            return get(identifier, 0, 0);
        }

        return get(identifier, 0);
    }

    public static Item get(ItemID identifier, int meta) {
        return get(identifier, meta, 1);
    }

    public static Item get(ItemID identifier, int meta, int count) {
        return get(identifier, meta, count, EmptyArrays.EMPTY_BYTES);
    }

    @PowerNukkitDifference(
            info = "Prevents players from getting invalid items by limiting the return to the maximum damage defined in Block.getMaxItemDamage()",
            since = "1.4.0.0-PN")
    public static Item get(ItemID identifier, Integer meta, int count, byte[] tags) {
        try {
            final Item item = identifier.getClazz().getConstructor(Integer.class, int.class).newInstance(meta, count);

            if (tags.length != 0) {
                item.setCompoundTag(tags);
            }

            return item;
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Item setCompoundTag(CompoundTag tag) {
        this.setNamedTag(tag);
        return this;
    }

    public Item setCompoundTag(byte[] tags) {
        this.tags = tags;
        this.cachedNBT = null;
        return this;
    }

    public byte[] getCompoundTag() {
        return tags;
    }

    public boolean hasCompoundTag() {
        return this.tags != null && this.tags.length > 0;
    }

    public boolean hasCustomBlockData() {
        if (!this.hasCompoundTag()) {
            return false;
        }

        CompoundTag tag = this.getNamedTag();
        return tag.contains("BlockEntityTag") && tag.get("BlockEntityTag") instanceof CompoundTag;

    }

    public Item clearCustomBlockData() {
        if (!this.hasCompoundTag()) {
            return this;
        }
        CompoundTag tag = this.getNamedTag();

        if (tag.contains("BlockEntityTag") && tag.get("BlockEntityTag") instanceof CompoundTag) {
            tag.remove("BlockEntityTag");
            this.setNamedTag(tag);
        }

        return this;
    }

    public Item setCustomBlockData(CompoundTag compoundTag) {
        CompoundTag tags = compoundTag.copy();
        tags.setName("BlockEntityTag");

        CompoundTag tag;
        if (!this.hasCompoundTag()) {
            tag = new CompoundTag();
        } else {
            tag = this.getNamedTag();
        }

        tag.putCompound("BlockEntityTag", tags);
        this.setNamedTag(tag);

        return this;
    }

    public CompoundTag getCustomBlockData() {
        if (!this.hasCompoundTag()) {
            return null;
        }

        CompoundTag tag = this.getNamedTag();

        if (tag.contains("BlockEntityTag")) {
            Tag bet = tag.get("BlockEntityTag");
            if (bet instanceof CompoundTag) {
                return (CompoundTag) bet;
            }
        }

        return null;
    }

    public boolean hasEnchantments() {
        if (!this.hasCompoundTag()) {
            return false;
        }

        CompoundTag tag = this.getNamedTag();

        if (tag.contains("ench")) {
            Tag enchTag = tag.get("ench");
            return enchTag instanceof ListTag;
        }

        return false;
    }


    /**
     * Find the enchantment level by the enchantment id.
     *
     * @param id The enchantment ID from {@link Enchantment} constants.
     * @return {@code 0} if the item don't have that enchantment or the current level of the given enchantment.
     */
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public int getEnchantmentLevel(int id) {
        if (!this.hasEnchantments()) {
            return 0;
        }

        for (CompoundTag entry : this.getNamedTag().getList("ench", CompoundTag.class).getAll()) {
            if (entry.getShort("id") == id) {
                return entry.getShort("lvl");
            }
        }

        return 0;
    }

    public Enchantment getEnchantment(int id) {
        return getEnchantment((short) (id & 0xffff));
    }

    public Enchantment getEnchantment(short id) {
        if (!this.hasEnchantments()) {
            return null;
        }

        for (CompoundTag entry : this.getNamedTag().getList("ench", CompoundTag.class).getAll()) {
            if (entry.getShort("id") == id) {
                Enchantment e = Enchantment.getEnchantment(entry.getShort("id"));
                if (e != null) {
                    e.setLevel(entry.getShort("lvl"), false);
                    return e;
                }
            }
        }

        return null;
    }

    public void addEnchantment(Enchantment... enchantments) {
        CompoundTag tag;
        if (!this.hasCompoundTag()) {
            tag = new CompoundTag();
        } else {
            tag = this.getNamedTag();
        }

        ListTag<CompoundTag> ench;
        if (!tag.contains("ench")) {
            ench = new ListTag<>("ench");
            tag.putList(ench);
        } else {
            ench = tag.getList("ench", CompoundTag.class);
        }

        for (Enchantment enchantment : enchantments) {
            boolean found = false;

            for (int k = 0; k < ench.size(); k++) {
                CompoundTag entry = ench.get(k);
                if (entry.getShort("id") == enchantment.getId()) {
                    ench.add(k, new CompoundTag()
                            .putShort("id", enchantment.getId())
                            .putShort("lvl", enchantment.getLevel())
                    );
                    found = true;
                    break;
                }
            }

            if (!found) {
                ench.add(new CompoundTag()
                        .putShort("id", enchantment.getId())
                        .putShort("lvl", enchantment.getLevel())
                );
            }
        }

        this.setNamedTag(tag);
    }

    public Enchantment[] getEnchantments() {
        if (!this.hasEnchantments()) {
            return Enchantment.EMPTY_ARRAY;
        }

        List<Enchantment> enchantments = new ArrayList<>();

        ListTag<CompoundTag> ench = this.getNamedTag().getList("ench", CompoundTag.class);
        for (CompoundTag entry : ench.getAll()) {
            Enchantment e = Enchantment.getEnchantment(entry.getShort("id"));
            if (e != null) {
                e.setLevel(entry.getShort("lvl"), false);
                enchantments.add(e);
            }
        }

        return enchantments.toArray(Enchantment.EMPTY_ARRAY);
    }

    /**
     * Convenience method to check if the item stack has positive level on a specific enchantment by it's id.
     *
     * @param id The enchantment ID from {@link Enchantment} constants.
     */
    @Since("1.4.0.0-PN")
    public boolean hasEnchantment(int id) {
        return this.getEnchantmentLevel(id) > 0;
    }

    @PowerNukkitOnly
    @Since("1.5.1.0-PN")
    @Nonnull
    public SideEffect[] getAttackSideEffects(@Nonnull Entity attacker, @Nonnull Entity entity) {
        return Arrays.stream(getEnchantments())
                .flatMap(enchantment -> Arrays.stream(enchantment.getAttackSideEffects(attacker, entity)))
                .filter(Objects::nonNull)
                .toArray(SideEffect[]::new)
                ;
    }

    @Since("1.4.0.0-PN")
    public int getRepairCost() {
        if (this.hasCompoundTag()) {
            CompoundTag tag = this.getNamedTag();
            if (tag.contains("RepairCost")) {
                Tag repairCost = tag.get("RepairCost");
                if (repairCost instanceof IntTag) {
                    return ((IntTag) repairCost).data;
                }
            }
        }
        return 0;
    }

    @Since("1.4.0.0-PN")
    public Item setRepairCost(int cost) {
        if (cost <= 0 && this.hasCompoundTag()) {
            return this.setNamedTag(this.getNamedTag().remove("RepairCost"));
        }

        CompoundTag tag;
        if (!this.hasCompoundTag()) {
            tag = new CompoundTag();
        } else {
            tag = this.getNamedTag();
        }
        return this.setNamedTag(tag.putInt("RepairCost", cost));
    }

    public boolean hasCustomName() {
        if (!this.hasCompoundTag()) {
            return false;
        }

        CompoundTag tag = this.getNamedTag();
        if (tag.contains("display")) {
            Tag tag1 = tag.get("display");
            return tag1 instanceof CompoundTag && ((CompoundTag) tag1).contains("Name") && ((CompoundTag) tag1).get("Name") instanceof StringTag;
        }

        return false;
    }

    public String getCustomName() {
        if (!this.hasCompoundTag()) {
            return "";
        }

        CompoundTag tag = this.getNamedTag();
        if (tag.contains("display")) {
            Tag tag1 = tag.get("display");
            if (tag1 instanceof CompoundTag && ((CompoundTag) tag1).contains("Name") && ((CompoundTag) tag1).get("Name") instanceof StringTag) {
                return ((CompoundTag) tag1).getString("Name");
            }
        }

        return "";
    }

    public Item setCustomName(String name) {
        if (name == null || name.equals("")) {
            this.clearCustomName();
        }

        CompoundTag tag;
        if (!this.hasCompoundTag()) {
            tag = new CompoundTag();
        } else {
            tag = this.getNamedTag();
        }
        if (tag.contains("display") && tag.get("display") instanceof CompoundTag) {
            tag.getCompound("display").putString("Name", name);
        } else {
            tag.putCompound("display", new CompoundTag("display")
                    .putString("Name", name)
            );
        }
        this.setNamedTag(tag);
        return this;
    }

    public Item clearCustomName() {
        if (!this.hasCompoundTag()) {
            return this;
        }

        CompoundTag tag = this.getNamedTag();

        if (tag.contains("display") && tag.get("display") instanceof CompoundTag) {
            tag.getCompound("display").remove("Name");
            if (tag.getCompound("display").isEmpty()) {
                tag.remove("display");
            }

            this.setNamedTag(tag);
        }

        return this;
    }

    public String[] getLore() {
        Tag tag = this.getNamedTagEntry("display");
        ArrayList<String> lines = new ArrayList<>();

        if (tag instanceof CompoundTag) {
            CompoundTag nbt = (CompoundTag) tag;
            ListTag<StringTag> lore = nbt.getList("Lore", StringTag.class);

            if (lore.size() > 0) {
                for (StringTag stringTag : lore.getAll()) {
                    lines.add(stringTag.data);
                }
            }
        }

        return lines.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    public Item setLore(String... lines) {
        CompoundTag tag;
        if (!this.hasCompoundTag()) {
            tag = new CompoundTag();
        } else {
            tag = this.getNamedTag();
        }
        ListTag<StringTag> lore = new ListTag<>("Lore");

        for (String line : lines) {
            lore.add(new StringTag("", line));
        }

        if (!tag.contains("display")) {
            tag.putCompound("display", new CompoundTag("display").putList(lore));
        } else {
            tag.getCompound("display").putList(lore);
        }

        this.setNamedTag(tag);
        return this;
    }

    public Tag getNamedTagEntry(String name) {
        CompoundTag tag = this.getNamedTag();
        if (tag != null) {
            return tag.contains(name) ? tag.get(name) : null;
        }

        return null;
    }

    public CompoundTag getNamedTag() {
        if (!this.hasCompoundTag()) {
            return null;
        }

        if (this.cachedNBT == null) {
            this.cachedNBT = parseCompoundTag(this.tags);
        }

        if (this.cachedNBT != null) {
            this.cachedNBT.setName("");
        }

        return this.cachedNBT;
    }

    public Item setNamedTag(CompoundTag tag) {
        if (tag.isEmpty()) {
            return this.clearNamedTag();
        }
        tag.setName(null);

        this.cachedNBT = tag;
        this.tags = writeCompoundTag(tag);

        return this;
    }

    public Item clearNamedTag() {
        return this.setCompoundTag(EmptyArrays.EMPTY_BYTES);
    }

    public static CompoundTag parseCompoundTag(byte[] tag) {
        try {
            return NBTIO.read(tag, ByteOrder.LITTLE_ENDIAN);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public byte[] writeCompoundTag(CompoundTag tag) {
        try {
            tag.setName("");
            return NBTIO.write(tag, ByteOrder.LITTLE_ENDIAN);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isNull() {
        return this.count <= 0 || this.identifier.equals(ItemID.AIR);
    }

    final public String getName() {
        return this.hasCustomName() ? this.getCustomName() : this.name;
    }

    final public boolean canBePlaced() {
        return ((this.block != null) && this.block.canBePlaced());
    }

    public Block getBlock() {
        if (this.block != null) {
            return this.block.clone();
        } else {
            return Block.get(BlockID.AIR);
        }
    }

    @Since("1.4.0.0-PN")
    @API(definition = API.Definition.INTERNAL, usage = API.Usage.INCUBATING)
    public Block getBlockUnsafe() {
        return this.block;
    }

    public ItemID getIdentifier() {
        return this.identifier;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockID getBlockId() {
        if (block != null) {
            return block.getId();
        } else {
            return BlockID.AIR;
        }
    }

    public int getDamage() {
        return meta;
    }

    public void setDamage(Integer meta) {
        if (meta != null) {
            this.meta = meta & 0xffff;
        } else {
            this.hasMeta = false;
        }
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public Item createFuzzyCraftingRecipe() {
        Item item = clone();
        item.hasMeta = false;
        return item;
    }

    public int getMaxStackSize() {
        return block == null ? 64 : block.getItemMaxStackSize();
    }

    final public Short getFuelTime() {
        if (!Fuel.duration.containsKey(this.identifier)) {
            return null;
        }
        if (!this.identifier.equals(ItemID.BUCKET) || this.meta == 10) {
            return Fuel.duration.get(this.identifier);
        }
        return null;
    }

    public boolean useOn(Entity entity) {
        return false;
    }

    public boolean useOn(Block block) {
        return false;
    }

    public boolean isTool() {
        return false;
    }

    public int getMaxDurability() {
        return -1;
    }

    public int getTier() {
        return 0;
    }

    public boolean isPickaxe() {
        return false;
    }

    public boolean isAxe() {
        return false;
    }

    public boolean isSword() {
        return false;
    }

    public boolean isShovel() {
        return false;
    }

    public boolean isHoe() {
        return false;
    }

    public boolean isShears() {
        return false;
    }

    public boolean isArmor() {
        return false;
    }

    public boolean isHelmet() {
        return false;
    }

    public boolean isChestplate() {
        return false;
    }

    public boolean isLeggings() {
        return false;
    }

    public boolean isBoots() {
        return false;
    }

    public int getEnchantAbility() {
        return 0;
    }

    public int getAttackDamage() {
        return 1;
    }

    public int getArmorPoints() {
        return 0;
    }

    public int getToughness() {
        return 0;
    }

    /**
     * If the item is resistant to lava and fire and can float on lava like if it was on water.
     *
     * @since 1.4.0.0-PN
     */
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public boolean isLavaResistant() {
        return false;
    }

    public boolean onUse(Player player, int ticksUsed) {
        return false;
    }

    /**
     * Allows the item to execute code when the player releases the item after long clicking it.
     *
     * @param player    The player who released the click button
     * @param ticksUsed How many ticks the item was held.
     * @return If an inventory contents update should be sent to the player
     */
    public boolean onRelease(Player player, int ticksUsed) {
        return false;
    }

    @Override
    final public String toString() {
        return "Item " + this.name + " (" + this.identifier + ":" + (!this.hasMeta ? "?" : this.meta) + ")x" + this.count + (this.hasCompoundTag() ? " tags:0x" + Binary.bytesToHexString(this.getCompoundTag()) : "");
    }

    public int getDestroySpeed(Block block, Player player) {
        return 1;
    }

    public boolean onActivate(Level level, Player player, Block block, Block target, BlockFace face, double fx, double fy, double fz) {
        return false;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public final Item decrement(int amount) {
        return increment(-amount);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public final Item increment(int amount) {
        if (count + amount <= 0) {
            return get(ItemID.AIR);
        }
        Item cloned = clone();
        cloned.count += amount;
        return cloned;
    }

    /**
     * When true, this item can be used to reduce growing times like a bone meal.
     *
     * @return {@code true} if it can act like a bone meal
     */
    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public boolean isFertilizer() {
        return false;
    }

    /**
     * Called when a player uses the item on air, for example throwing a projectile.
     * Returns whether the item was changed, for example count decrease or durability change.
     *
     * @param player          player
     * @param directionVector direction
     * @return item changed
     */
    public boolean onClickAir(Player player, Vector3 directionVector) {
        return false;
    }

    @Override
    public final boolean equals(Object item) {
        return item instanceof Item && this.equals((Item) item, true);
    }

    public final boolean equals(Item item, boolean checkDamage) {
        return equals(item, checkDamage, true);
    }

    public final boolean equals(Item item, boolean checkDamage, boolean checkCompound) {
        if (this.getIdentifier() == item.getIdentifier() && (!checkDamage || this.getDamage() == item.getDamage())) {
            if (checkCompound) {
                if (Arrays.equals(this.getCompoundTag(), item.getCompoundTag())) {
                    return true;
                } else if (this.hasCompoundTag() && item.hasCompoundTag()) {
                    return this.getNamedTag().equals(item.getNamedTag());
                }
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * Returns whether the specified item stack has the same ID, damage, NBT and count as this item stack.
     *
     * @param other item
     * @return equal
     */
    public final boolean equalsExact(Item other) {
        return this.equals(other, true, true) && this.count == other.count;
    }

    /**
     * Same as {@link #equals(Item, boolean)} but the enchantment order of the items does not affect the result.
     *
     * @since 1.2.1.0-PN
     */
    @PowerNukkitOnly
    @Since("1.2.1.0-PN")
    public final boolean equalsIgnoringEnchantmentOrder(Item item, boolean checkDamage) {
        if (!this.equals(item, checkDamage, false)) {
            return false;
        }

        if (Arrays.equals(this.getCompoundTag(), item.getCompoundTag())) {
            return true;
        }

        if (!this.hasCompoundTag() || !item.hasCompoundTag()) {
            return false;
        }

        CompoundTag thisTags = this.getNamedTag();
        CompoundTag otherTags = item.getNamedTag();
        if (thisTags.equals(otherTags)) {
            return true;
        }

        if (!thisTags.contains("ench") || !otherTags.contains("ench")
                || !(thisTags.get("ench") instanceof ListTag)
                || !(otherTags.get("ench") instanceof ListTag)
                || thisTags.getList("ench").size() != otherTags.getList("ench").size()) {
            return false;
        }

        ListTag<CompoundTag> thisEnchantmentTags = thisTags.getList("ench", CompoundTag.class);
        ListTag<CompoundTag> otherEnchantmentTags = otherTags.getList("ench", CompoundTag.class);

        int size = thisEnchantmentTags.size();
        Int2IntMap enchantments = new Int2IntArrayMap(size);
        enchantments.defaultReturnValue(Integer.MIN_VALUE);

        for (int i = 0; i < size; i++) {
            CompoundTag tag = thisEnchantmentTags.get(i);
            enchantments.put(tag.getShort("id"), tag.getShort("lvl"));
        }

        for (int i = 0; i < size; i++) {
            CompoundTag tag = otherEnchantmentTags.get(i);
            if (enchantments.get(tag.getShort("id")) != tag.getShort("lvl")) {
                return false;
            }
        }

        return true;
    }

    @Deprecated
    public final boolean deepEquals(Item item) {
        return equals(item, true);
    }

    @Deprecated
    public final boolean deepEquals(Item item, boolean checkDamage) {
        return equals(item, checkDamage, true);
    }

    @Deprecated
    public final boolean deepEquals(Item item, boolean checkDamage, boolean checkCompound) {
        return equals(item, checkDamage, checkCompound);
    }

    @Override
    public Item clone() {
        try {
            Item item = (Item) super.clone();
            item.tags = this.tags.clone();
            item.cachedNBT = null;
            return item;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @PowerNukkitOnly
    public boolean isAny(ItemID... ids) {
        for (ItemID id : ids) {
            if (id.equals(getIdentifier())) {
                return true;
            }
        }

        return false;
    }
}
