package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBirchChestBoat extends Item {

    public ItemBirchChestBoat() {
        this(0, 1);
    }

    public ItemBirchChestBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemBirchChestBoat(Integer meta, int count) {
        super(ItemID.BIRCH_CHEST_BOAT, meta, count, "Birch Chest Boat");
    }
}