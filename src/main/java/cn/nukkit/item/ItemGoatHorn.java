package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGoatHorn extends Item {

    public ItemGoatHorn() {
        this(0, 1);
    }

    public ItemGoatHorn(Integer meta) {
        this(meta, 1);
    }

    public ItemGoatHorn(Integer meta, int count) {
        super(ItemID.GOAT_HORN, meta, count, "Goat Horn");
    }
}