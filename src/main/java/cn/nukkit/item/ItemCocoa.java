package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCocoa extends Item {

    public ItemCocoa() {
        this(0, 1);
    }

    public ItemCocoa(Integer meta) {
        this(meta, 1);
    }

    public ItemCocoa(Integer meta, int count) {
        super(ItemID.COCOA, meta, count, "Cocoa");
    }
}