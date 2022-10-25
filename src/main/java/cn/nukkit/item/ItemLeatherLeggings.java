package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLeatherLeggings extends Item {

    public ItemLeatherLeggings() {
        this(0, 1);
    }

    public ItemLeatherLeggings(Integer meta) {
        this(meta, 1);
    }

    public ItemLeatherLeggings(Integer meta, int count) {
        super(ItemID.LEATHER_LEGGINGS, meta, count, "Leather Leggings");
    }
}