package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOrangeDye extends ItemDye {

    public ItemOrangeDye() {
        this(0, 1);
    }

    public ItemOrangeDye(Integer meta) {
        this(meta, 1);
    }

    public ItemOrangeDye(Integer meta, int count) {
        super(ItemID.ORANGE_DYE, meta, count, "Orange Dye");
    }
}