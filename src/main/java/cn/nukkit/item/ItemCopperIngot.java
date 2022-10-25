package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCopperIngot extends Item {

    public ItemCopperIngot() {
        this(0, 1);
    }

    public ItemCopperIngot(Integer meta) {
        this(meta, 1);
    }

    public ItemCopperIngot(Integer meta, int count) {
        super(ItemID.COPPER_INGOT, meta, count, "Copper Ingot");
    }
}