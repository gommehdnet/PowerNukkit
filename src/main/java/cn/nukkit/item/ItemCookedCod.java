package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemCookedCod extends ItemCod {

    public ItemCookedCod() {
        this(0, 1);
    }

    public ItemCookedCod(Integer meta) {
        this(meta, 1);
    }

    public ItemCookedCod(Integer meta, int count) {
        super(ItemID.COOKED_COD, meta, count, "Cooked Cod");
    }

}
