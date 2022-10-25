package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemChicken extends ItemEdible {

    public ItemChicken() {
        this(0, 1);
    }

    public ItemChicken(Integer meta) {
        this(meta, 1);
    }

    public ItemChicken(Integer meta, int count) {
        super(ItemID.CHICKEN, meta, count, "Raw Chicken");
    }
}
