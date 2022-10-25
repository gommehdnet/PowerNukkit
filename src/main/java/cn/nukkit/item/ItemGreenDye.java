package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGreenDye extends ItemDye {

    public ItemGreenDye() {
        this(0, 1);
    }

    public ItemGreenDye(Integer meta) {
        this(meta, 1);
    }

    public ItemGreenDye(Integer meta, int count) {
        super(ItemID.GREEN_DYE, meta, count, "Green Dye");
    }
}