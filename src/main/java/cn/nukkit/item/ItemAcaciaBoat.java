package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAcaciaBoat extends Item {

    public ItemAcaciaBoat() {
        this(0, 1);
    }

    public ItemAcaciaBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemAcaciaBoat(Integer meta, int count) {
        super(ItemID.ACACIA_BOAT, meta, count, "Acacia Boat");
    }
}