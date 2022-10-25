package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCyanDye extends ItemDye {

    public ItemCyanDye() {
        this(0, 1);
    }

    public ItemCyanDye(Integer meta) {
        this(meta, 1);
    }

    public ItemCyanDye(Integer meta, int count) {
        super(ItemID.CYAN_DYE, meta, count, "Cyan Dye");
    }
}