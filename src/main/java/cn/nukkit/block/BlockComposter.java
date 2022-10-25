package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.IntBlockProperty;
import cn.nukkit.event.block.ComposterEmptyEvent;
import cn.nukkit.event.block.ComposterFillEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemDye;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.level.Sound;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Random;

@PowerNukkitOnly
public class BlockComposter extends BlockSolidMeta {

    private static Int2IntOpenHashMap compostableItems = new Int2IntOpenHashMap();
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static final IntBlockProperty COMPOSTER_FILL_LEVEL = new IntBlockProperty("composter_fill_level", false, 8);
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static final BlockProperties PROPERTIES = new BlockProperties(COMPOSTER_FILL_LEVEL);

    static {
        registerDefaults();
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    @PowerNukkitOnly
    public BlockComposter() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockComposter(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.COMPOSTER;
    }

    @Override
    public String getName() {
        return "Composter";
    }

    @Override
    public double getHardness() {
        return 0.6;
    }

    @Override
    public double getResistance() {
        return 0.6;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_AXE;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @PowerNukkitOnly
    @Override
    public int getWaterloggingLevel() {
        return 1;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.COMPOSTER);
    }

    @Override
    public boolean hasComparatorInputOverride() {
        return true;
    }

    @Override
    public int getComparatorInputOverride() {
        return getPropertyValue(COMPOSTER_FILL_LEVEL);
    }

    @PowerNukkitOnly
    public boolean incrementLevel() {
        int fillLevel = getPropertyValue(COMPOSTER_FILL_LEVEL) + 1;
        setPropertyValue(COMPOSTER_FILL_LEVEL, fillLevel);
        this.level.setBlock(this, this, true, true);
        return fillLevel == 8;
    }

    @PowerNukkitOnly
    public boolean isFull() {
        return getPropertyValue(COMPOSTER_FILL_LEVEL) == 8;
    }

    @PowerNukkitOnly
    public boolean isEmpty() {
        return getPropertyValue(COMPOSTER_FILL_LEVEL) == 0;
    }

    @PowerNukkitDifference(info = "Player is null when is called from BlockEntityHopper")
    @Override
    public boolean onActivate(@Nonnull Item item, Player player) {
        if (item.getCount() <= 0 || item.getIdentifier() == ItemID.AIR) {
            return false;
        }

        if (isFull()) {
            ComposterEmptyEvent event = new ComposterEmptyEvent(this, player, item, Item.get(ItemID.BONE_MEAL), 0);
            this.level.getServer().getPluginManager().callEvent(event);
            if (!event.isCancelled()) {
                setDamage(event.getNewLevel());
                this.level.setBlock(this, this, true, true);
                this.level.dropItem(add(0.5, 0.85, 0.5), event.getDrop(), event.getMotion(), false, 10);
                this.level.addSound(add(0.5, 0.5, 0.5), Sound.BLOCK_COMPOSTER_EMPTY);
            }
            return true;
        }

        int chance = getChance(item);
        if (chance <= 0) {
            return false;
        }

        boolean success = new Random().nextInt(100) < chance;
        ComposterFillEvent event = new ComposterFillEvent(this, player, item, chance, success);
        this.level.getServer().getPluginManager().callEvent(event);

        if (event.isCancelled()) {
            return true;
        }

        if (player != null && !player.isCreative()) {
            item.setCount(item.getCount() - 1);
        }

        if (event.isSuccess()) {
            if (incrementLevel()) {
                level.addSound(this.add(0.5, 0.5, 0.5), Sound.BLOCK_COMPOSTER_READY);
            } else {
                level.addSound(this.add(0.5, 0.5, 0.5), Sound.BLOCK_COMPOSTER_FILL_SUCCESS);
            }
        } else {
            level.addSound(this.add(0.5, 0.5, 0.5), Sound.BLOCK_COMPOSTER_FILL);
        }

        return true;
    }

    @PowerNukkitOnly
    public Item empty() {
        return empty(null, null);
    }

    @PowerNukkitOnly
    public Item empty(@Nullable Item item, @Nullable Player player) {
        ComposterEmptyEvent event = new ComposterEmptyEvent(this, player, item, new ItemDye(ItemID.WHITE_DYE, 0, 1), 0);
        this.level.getServer().getPluginManager().callEvent(event);
        if (!event.isCancelled()) {
            setPropertyValue(COMPOSTER_FILL_LEVEL, event.getNewLevel());
            this.level.setBlock(this, this, true, true);
            if (item != null) {
                this.level.dropItem(add(0.5, 0.85, 0.5), event.getDrop(), event.getMotion(), false, 10);
            }
            this.level.addSound(add(0.5, 0.5, 0.5), Sound.BLOCK_COMPOSTER_EMPTY);
            return event.getDrop();
        }
        return null;
    }

    @PowerNukkitOnly
    public static void registerItem(int chance, ItemID itemId) {
        compostableItems.put(itemId.getNetworkId() << 6, chance);
    }

    @PowerNukkitOnly
    public static void registerItems(int chance, ItemID... itemIds) {
        for (ItemID itemId : itemIds) {
            registerItem(chance, itemId);
        }
    }

    @PowerNukkitOnly
    public static void registerBlocks(int chance, ItemID... blockIds) {
        for (ItemID blockId : blockIds) {
            registerBlock(chance, blockId);
        }
    }

    @PowerNukkitOnly
    public static void registerBlock(int chance, ItemID blockId) {
        registerItem(chance, blockId);
    }

    @PowerNukkitOnly
    public static void register(int chance, Item item) {
        registerItem(chance, item.getIdentifier());
    }

    @PowerNukkitOnly
    public static int getChance(Item item) {
        int chance = compostableItems.get(item.getIdentifier().getNetworkId() << 6);
        if (chance == 0) {
            chance = compostableItems.get(item.getIdentifier().getNetworkId() << 6);
        }
        return chance;
    }

    private static void registerDefaults() {
        registerItems(30, ItemID.KELP, ItemID.BEETROOT_SEEDS, ItemID.DRIED_KELP, ItemID.MELON_SEEDS, ItemID.PUMPKIN_SEEDS, ItemID.SWEET_BERRIES, ItemID.WHEAT_SEEDS);
        registerItems(50, ItemID.MELON_SLICE, ItemID.SUGAR_CANE, ItemID.NETHER_SPROUTS);
        registerItems(65, ItemID.APPLE, ItemID.BEETROOT, ItemID.CARROT, ItemID.COCOA, ItemID.POTATO, ItemID.WHEAT);
        registerItems(85, ItemID.BAKED_POTATO, ItemID.BREAD, ItemID.COOKIE);
        registerItems(100, ItemID.CAKE, ItemID.PUMPKIN_PIE);

        registerBlocks(30, ItemID.KELP, ItemID.LEAVES, ItemID.LEAVES2, ItemID.SAPLING, ItemID.SEAGRASS, ItemID.SWEET_BERRY_BUSH);
        registerBlocks(50, ItemID.GRASS, ItemID.CACTUS, ItemID.DRIED_KELP_BLOCK, ItemID.VINE, ItemID.NETHER_SPROUTS,
                ItemID.TWISTING_VINES, ItemID.WEEPING_VINES);
        registerBlocks(65, ItemID.YELLOW_FLOWER, ItemID.RED_FLOWER, ItemID.DOUBLE_PLANT, ItemID.WITHER_ROSE, ItemID.WATERLILY, ItemID.MELON_BLOCK,
                ItemID.PUMPKIN, ItemID.CARVED_PUMPKIN, ItemID.SEA_PICKLE, ItemID.BROWN_MUSHROOM, ItemID.RED_MUSHROOM,
                ItemID.WARPED_ROOTS, ItemID.CRIMSON_ROOTS, ItemID.SHROOMLIGHT);
        registerBlocks(85, ItemID.HAY_BLOCK, ItemID.BROWN_MUSHROOM_BLOCK, ItemID.RED_MUSHROOM_BLOCK, ItemID.MUSHROOM_STEW);
        registerBlocks(100, ItemID.CAKE);

        registerBlock(50, ItemID.TALLGRASS);
    }
}
