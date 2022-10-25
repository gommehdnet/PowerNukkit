package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLightGrayDye extends ItemDye {

    public ItemLightGrayDye() {
        this(0, 1);
    }

    public ItemLightGrayDye(Integer meta) {
        this(meta, 1);
    }

    public ItemLightGrayDye(Integer meta, int count) {
        super(ItemID.LIGHT_GRAY_DYE, meta, count, "Light Gray Dye");
    }
}