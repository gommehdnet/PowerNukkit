package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemYellowDye extends ItemDye {

    public ItemYellowDye() {
        this(0, 1);
    }

    public ItemYellowDye(Integer meta) {
        this(meta, 1);
    }

    public ItemYellowDye(Integer meta, int count) {
        super(ItemID.YELLOW_DYE, meta, count, "Yellow Dye");
    }
}