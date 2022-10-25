package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveBoat extends Item {

    public ItemMangroveBoat() {
        this(0, 1);
    }

    public ItemMangroveBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveBoat(Integer meta, int count) {
        super(ItemID.MANGROVE_BOAT, meta, count, "Mangrove Boat");
    }
}