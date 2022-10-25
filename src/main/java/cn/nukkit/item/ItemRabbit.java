package cn.nukkit.item;

/**
 * @author Snake1999
 * @since 2016/1/14
 */
public class ItemRabbit extends ItemEdible {
    public ItemRabbit() {
        this(0, 1);
    }

    public ItemRabbit(Integer meta) {
        this(meta, 1);
    }

    public ItemRabbit(Integer meta, int count) {
        super(ItemID.RABBIT, meta, count, "Raw Rabbit");
    }

}
