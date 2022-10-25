package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemClayBall extends Item {

    public ItemClayBall() {
        this(0, 1);
    }

    public ItemClayBall(Integer meta) {
        this(meta, 1);
    }

    public ItemClayBall(Integer meta, int count) {
        super(ItemID.CLAY_BALL, meta, count, "Clay Ball");
    }
}