package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemCookedPorkchop extends ItemEdible {

    public ItemCookedPorkchop() {
        this(0, 1);
    }

    public ItemCookedPorkchop(Integer meta) {
        this(meta, 1);
    }

    public ItemCookedPorkchop(Integer meta, int count) {
        super(ItemID.COOKED_PORKCHOP, meta, count, "Cooked Porkchop");
    }
}
