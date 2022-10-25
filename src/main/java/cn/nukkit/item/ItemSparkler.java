package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSparkler extends Item {

    public ItemSparkler() {
        this(0, 1);
    }

    public ItemSparkler(Integer meta) {
        this(meta, 1);
    }

    public ItemSparkler(Integer meta, int count) {
        super(ItemID.SPARKLER, meta, count, "Sparkler");
    }
}