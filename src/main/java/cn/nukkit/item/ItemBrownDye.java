package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBrownDye extends ItemDye {

    public ItemBrownDye() {
        this(0, 1);
    }

    public ItemBrownDye(Integer meta) {
        this(meta, 1);
    }

    public ItemBrownDye(Integer meta, int count) {
        super(ItemID.BROWN_DYE, meta, count, "Brown Dye");
    }
}