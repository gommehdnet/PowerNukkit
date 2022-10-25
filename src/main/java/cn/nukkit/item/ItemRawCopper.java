package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRawCopper extends Item {

    public ItemRawCopper() {
        this(0, 1);
    }

    public ItemRawCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemRawCopper(Integer meta, int count) {
        super(ItemID.RAW_COPPER, meta, count, "Raw Copper");
    }
}