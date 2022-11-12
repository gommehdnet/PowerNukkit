package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBirchBoat extends ItemBoat {

    public ItemBirchBoat() {
        this(0, 1);
    }

    public ItemBirchBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemBirchBoat(Integer meta, int count) {
        super(ItemID.BIRCH_BOAT, meta, count, "Birch Boat");
        this.variant = 2;
    }
}