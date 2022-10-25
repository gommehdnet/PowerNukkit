package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRawGold extends Item {

    public ItemRawGold() {
        this(0, 1);
    }

    public ItemRawGold(Integer meta) {
        this(meta, 1);
    }

    public ItemRawGold(Integer meta, int count) {
        super(ItemID.RAW_GOLD, meta, count, "Raw Gold");
    }
}