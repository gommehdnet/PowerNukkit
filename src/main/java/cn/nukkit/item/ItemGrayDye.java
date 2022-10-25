package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGrayDye extends ItemDye {

    public ItemGrayDye() {
        this(0, 1);
    }

    public ItemGrayDye(Integer meta) {
        this(meta, 1);
    }

    public ItemGrayDye(Integer meta, int count) {
        super(ItemID.GRAY_DYE, meta, count, "Gray Dye");
    }
}