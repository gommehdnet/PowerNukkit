package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlackDye extends ItemDye {

    public ItemBlackDye() {
        this(0, 1);
    }

    public ItemBlackDye(Integer meta) {
        this(meta, 1);
    }

    public ItemBlackDye(Integer meta, int count) {
        super(ItemID.BLACK_DYE, meta, count, "Black Dye");
    }
}