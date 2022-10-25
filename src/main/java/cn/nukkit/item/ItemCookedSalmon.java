package cn.nukkit.item;

/**
 * @author Snake1999
 * @since 2016/1/14
 */
public class ItemCookedSalmon extends ItemCod {

    public ItemCookedSalmon() {
        this(0, 1);
    }

    public ItemCookedSalmon(Integer meta) {
        this(meta, 1);
    }

    public ItemCookedSalmon(Integer meta, int count) {
        super(ItemID.COOKED_SALMON, meta, count, "Cooked Salmon");
    }

}
