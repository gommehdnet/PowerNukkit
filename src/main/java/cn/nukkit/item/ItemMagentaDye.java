package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMagentaDye extends ItemDye {

    public ItemMagentaDye() {
        this(0, 1);
    }

    public ItemMagentaDye(Integer meta) {
        this(meta, 1);
    }

    public ItemMagentaDye(Integer meta, int count) {
        super(ItemID.MAGENTA_DYE, meta, count, "Magenta Dye");
    }
}