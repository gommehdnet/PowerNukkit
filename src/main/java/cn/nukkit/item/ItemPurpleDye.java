package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPurpleDye extends ItemDye {

    public ItemPurpleDye() {
        this(0, 1);
    }

    public ItemPurpleDye(Integer meta) {
        this(meta, 1);
    }

    public ItemPurpleDye(Integer meta, int count) {
        super(ItemID.PURPLE_DYE, meta, count, "Purple Dye");
    }
}