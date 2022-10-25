package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCocoaBeans extends Item {

    public ItemCocoaBeans() {
        this(0, 1);
    }

    public ItemCocoaBeans(Integer meta) {
        this(meta, 1);
    }

    public ItemCocoaBeans(Integer meta, int count) {
        super(ItemID.COCOA_BEANS, meta, count, "Cocoa Beans");
    }
}