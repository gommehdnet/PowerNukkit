package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemGoldIngot extends Item {

    public ItemGoldIngot() {
        this(0, 1);
    }

    public ItemGoldIngot(Integer meta) {
        this(meta, 1);
    }

    public ItemGoldIngot(Integer meta, int count) {
        super(ItemID.GOLD_INGOT, 0, count, "Gold Ingot");
    }
}
