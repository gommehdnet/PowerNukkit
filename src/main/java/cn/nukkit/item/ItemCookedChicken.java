package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemCookedChicken extends ItemEdible {

    public ItemCookedChicken() {
        this(0, 1);
    }

    public ItemCookedChicken(Integer meta) {
        this(meta, 1);
    }

    public ItemCookedChicken(Integer meta, int count) {
        super(ItemID.COOKED_CHICKEN, meta, count, "Cooked Chicken");
    }
}
