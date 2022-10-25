package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedDye extends ItemDye {

    public ItemRedDye() {
        this(0, 1);
    }

    public ItemRedDye(Integer meta) {
        this(meta, 1);
    }

    public ItemRedDye(Integer meta, int count) {
        super(ItemID.RED_DYE, meta, count, "Red Dye");
    }
}