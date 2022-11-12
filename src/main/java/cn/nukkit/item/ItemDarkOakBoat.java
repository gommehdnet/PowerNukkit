package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDarkOakBoat extends ItemBoat {

    public ItemDarkOakBoat() {
        this(0, 1);
    }

    public ItemDarkOakBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemDarkOakBoat(Integer meta, int count) {
        super(ItemID.DARK_OAK_BOAT, meta, count, "Dark Oak Boat");
        this.variant = 5;
    }
}