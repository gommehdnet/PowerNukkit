package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLimeDye extends ItemDye {

    public ItemLimeDye() {
        this(0, 1);
    }

    public ItemLimeDye(Integer meta) {
        this(meta, 1);
    }

    public ItemLimeDye(Integer meta, int count) {
        super(ItemID.LIME_DYE, meta, count, "Lime Dye");
    }
}