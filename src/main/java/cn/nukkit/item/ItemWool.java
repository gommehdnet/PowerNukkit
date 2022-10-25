package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWool extends Item {

    public ItemWool() {
        this(0, 1);
    }

    public ItemWool(Integer meta) {
        this(meta, 1);
    }

    public ItemWool(Integer meta, int count) {
        super(ItemID.WOOL, 0, count, "Wool");
    }
}