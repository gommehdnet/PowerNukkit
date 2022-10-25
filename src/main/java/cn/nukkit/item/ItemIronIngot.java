package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemIronIngot extends Item {

    public ItemIronIngot() {
        this(0, 1);
    }

    public ItemIronIngot(Integer meta) {
        this(meta, 1);
    }

    public ItemIronIngot(Integer meta, int count) {
        super(ItemID.IRON_INGOT, 0, count, "Iron Ingot");
    }
}
