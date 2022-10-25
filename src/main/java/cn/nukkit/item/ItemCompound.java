package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCompound extends Item {

    public ItemCompound() {
        this(0, 1);
    }

    public ItemCompound(Integer meta) {
        this(meta, 1);
    }

    public ItemCompound(Integer meta, int count) {
        super(ItemID.COMPOUND, meta, count, "Compound");
    }
}