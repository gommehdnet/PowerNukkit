package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDiscFragment5 extends Item {

    public ItemDiscFragment5() {
        this(0, 1);
    }

    public ItemDiscFragment5(Integer meta) {
        this(meta, 1);
    }

    public ItemDiscFragment5(Integer meta, int count) {
        super(ItemID.DISC_FRAGMENT_5, meta, count, "Disc Fragment 5");
    }
}