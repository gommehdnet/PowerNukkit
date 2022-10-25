package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemCod extends ItemEdible {

    public ItemCod() {
        this(0, 1);
    }

    public ItemCod(Integer meta) {
        this(meta, 1);
    }

    public ItemCod(Integer meta, int count) {
        super(ItemID.COD, meta, count, "Cod");
    }

    protected ItemCod(ItemID id, Integer meta, int count, String name) {
        super(id, meta, count, name);
    }

}
