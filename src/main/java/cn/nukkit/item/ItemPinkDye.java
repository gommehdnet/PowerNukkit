package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPinkDye extends ItemDye {

    public ItemPinkDye() {
        this(0, 1);
    }

    public ItemPinkDye(Integer meta) {
        this(meta, 1);
    }

    public ItemPinkDye(Integer meta, int count) {
        super(ItemID.PINK_DYE, meta, count, "Pink Dye");
    }
}