package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBlueDye extends ItemDye {

    public ItemBlueDye() {
        this(0, 1);
    }

    public ItemBlueDye(Integer meta) {
        this(meta, 1);
    }

    public ItemBlueDye(Integer meta, int count) {
        super(ItemID.BLUE_DYE, meta, count, "Blue Dye");
    }
}