package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemInkSac extends Item {

    public ItemInkSac() {
        this(0, 1);
    }

    public ItemInkSac(Integer meta) {
        this(meta, 1);
    }

    public ItemInkSac(Integer meta, int count) {
        super(ItemID.INK_SAC, meta, count, "Ink Sac");
    }
}