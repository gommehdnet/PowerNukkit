package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLightBlueDye extends ItemDye {

    public ItemLightBlueDye() {
        this(0, 1);
    }

    public ItemLightBlueDye(Integer meta) {
        this(meta, 1);
    }

    public ItemLightBlueDye(Integer meta, int count) {
        super(ItemID.LIGHT_BLUE_DYE, meta, count, "Light Blue Dye");
    }
}