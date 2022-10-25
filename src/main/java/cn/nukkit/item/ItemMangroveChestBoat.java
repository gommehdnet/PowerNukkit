package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveChestBoat extends Item {

    public ItemMangroveChestBoat() {
        this(0, 1);
    }

    public ItemMangroveChestBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveChestBoat(Integer meta, int count) {
        super(ItemID.MANGROVE_CHEST_BOAT, meta, count, "Mangrove Chest Boat");
    }
}