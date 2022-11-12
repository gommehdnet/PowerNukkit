package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOakBoat extends ItemBoat {

    public ItemOakBoat() {
        this(0, 1);
    }

    public ItemOakBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemOakBoat(Integer meta, int count) {
        super(ItemID.OAK_BOAT, meta, count, "Oak Boat");
    }
}