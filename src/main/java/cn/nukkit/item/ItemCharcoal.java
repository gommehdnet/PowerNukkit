package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCharcoal extends Item {

    public ItemCharcoal() {
        this(0, 1);
    }

    public ItemCharcoal(Integer meta) {
        this(meta, 1);
    }

    public ItemCharcoal(Integer meta, int count) {
        super(ItemID.CHARCOAL, meta, count, "Charcoal");
    }
}