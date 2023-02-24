package cn.nukkit.inventory;

import cn.nukkit.item.ItemID;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public abstract class Fuel {
    public static final Map<ItemID, Short> duration = new TreeMap<>();

    static {
        addItem(ItemID.COAL, (short) 1600);
        addBlock(ItemID.COAL_BLOCK, (short) 16000);
        addBlock(ItemID.PLANKS, (short) 300);
        addBlock(ItemID.SAPLING, (short) 100);
        addItem(ItemID.WOODEN_AXE, (short) 200);
        addItem(ItemID.WOODEN_PICKAXE, (short) 200);
        addItem(ItemID.WOODEN_SWORD, (short) 200);
        addItem(ItemID.WOODEN_SHOVEL, (short) 200);
        addItem(ItemID.WOODEN_HOE, (short) 200);
        addItem(ItemID.STICK, (short) 100);
        addBlock(ItemID.FENCE, (short) 300);
        addBlock(ItemID.FENCE_GATE, (short) 300);
        addBlock(ItemID.SPRUCE_FENCE_GATE, (short) 300);
        addBlock(ItemID.BIRCH_FENCE_GATE, (short) 300);
        addBlock(ItemID.JUNGLE_FENCE_GATE, (short) 300);
        addBlock(ItemID.ACACIA_FENCE_GATE, (short) 300);
        addBlock(ItemID.DARK_OAK_FENCE_GATE, (short) 300);
        addBlock(ItemID.OAK_STAIRS, (short) 300);
        addBlock(ItemID.SPRUCE_STAIRS, (short) 300);
        addBlock(ItemID.BIRCH_STAIRS, (short) 300);
        addBlock(ItemID.JUNGLE_STAIRS, (short) 300);
        addBlock(ItemID.TRAPDOOR, (short) 300);
        addBlock(ItemID.CRAFTING_TABLE, (short) 300);
        addBlock(ItemID.BOOKSHELF, (short) 300);
        addBlock(ItemID.CHEST, (short) 300);
        addItem(ItemID.BUCKET, (short) 20000);
        addBlock(ItemID.LADDER, (short) 300);
        addItem(ItemID.BOW, (short) 200);
        addItem(ItemID.BOWL, (short) 100);
        addBlock(ItemID.LOG, (short) 300);
        addBlock(ItemID.WOODEN_PRESSURE_PLATE, (short) 300);
        addBlock(ItemID.ACACIA_STAIRS, (short) 300);
        addBlock(ItemID.DARK_OAK_STAIRS, (short) 300);
        addBlock(ItemID.TRAPPED_CHEST, (short) 300);
        addBlock(ItemID.DAYLIGHT_DETECTOR, (short) 300);
        addBlock(ItemID.DAYLIGHT_DETECTOR_INVERTED, (short) 300);
        addBlock(ItemID.JUKEBOX, (short) 300);
        addBlock(ItemID.NOTEBLOCK, (short) 300);
        addBlock(ItemID.WOODEN_SLAB, (short) 300);
        addBlock(ItemID.DOUBLE_WOODEN_SLAB, (short) 300);
        addItem(ItemID.BOAT, (short) 1200);
        addItem(ItemID.BLAZE_ROD, (short) 2400);
        addBlock(ItemID.BROWN_MUSHROOM_BLOCK, (short) 300);
        addBlock(ItemID.RED_MUSHROOM_BLOCK, (short) 300);
        addItem(ItemID.FISHING_ROD, (short) 300);
        addBlock(ItemID.WOODEN_BUTTON, (short) 100);
        addItem(ItemID.WOODEN_DOOR, (short) 200);
        addItem(ItemID.SPRUCE_DOOR, (short) 200);
        addItem(ItemID.BIRCH_DOOR, (short) 200);
        addItem(ItemID.JUNGLE_DOOR, (short) 200);
        addItem(ItemID.ACACIA_DOOR, (short) 200);
        addItem(ItemID.DARK_OAK_DOOR, (short) 200);
        addItem(ItemID.BANNER, (short) 300);
        addBlock(ItemID.DEADBUSH, (short) 100);
        addItem(ItemID.OAK_SIGN, (short) 200);
        addItem(ItemID.ACACIA_SIGN, (short) 200);
        addItem(ItemID.BIRCH_SIGN, (short) 200);
        addItem(ItemID.SPRUCE_SIGN, (short) 200);
        addItem(ItemID.DARK_OAK_SIGN, (short) 200);
        addItem(ItemID.JUNGLE_SIGN, (short) 200);
        addBlock(ItemID.DRIED_KELP_BLOCK, (short) 4000);
        addItem(ItemID.CROSSBOW, (short) 200);
        addItem(ItemID.AZALEA, (short) 50);
    }

    private static void addItem(ItemID itemID, short fuelDuration) {
        duration.put(itemID, fuelDuration);
    }

    private static void addBlock(ItemID blockID, short fuelDuration) {
        duration.put(blockID, fuelDuration); // ItemBlock have a negative ID
    }
}
