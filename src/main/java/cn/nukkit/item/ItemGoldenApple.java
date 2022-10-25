package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGoldenApple extends Item {

    public ItemGoldenApple() {
        this(0, 1);
    }

    public ItemGoldenApple(Integer meta) {
        this(meta, 1);
    }

    public ItemGoldenApple(Integer meta, int count) {
        super(ItemID.GOLDEN_APPLE, meta, count, "Golden Apple");
    }
}