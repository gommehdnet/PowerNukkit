package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBalloon extends Item {

    public ItemBalloon() {
        this(0, 1);
    }

    public ItemBalloon(Integer meta) {
        this(meta, 1);
    }

    public ItemBalloon(Integer meta, int count) {
        super(ItemID.BALLOON, meta, count, "Balloon");
    }
}