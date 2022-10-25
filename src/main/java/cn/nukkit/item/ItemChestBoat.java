package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemChestBoat extends Item {

    public ItemChestBoat() {
        this(0, 1);
    }

    public ItemChestBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemChestBoat(Integer meta, int count) {
        super(ItemID.CHEST_BOAT, meta, count, "Chest Boat");
    }
}