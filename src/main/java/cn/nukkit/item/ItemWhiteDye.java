package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWhiteDye extends ItemDye {

    public ItemWhiteDye() {
        this(0, 1);
    }

    public ItemWhiteDye(Integer meta) {
        this(meta, 1);
    }

    public ItemWhiteDye(Integer meta, int count) {
        super(ItemID.WHITE_DYE, meta, count, "White Dye");
    }
}