package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemCookedBeef extends ItemEdible {

    public ItemCookedBeef() {
        this(0, 1);
    }

    public ItemCookedBeef(Integer meta) {
        this(meta, 1);
    }

    public ItemCookedBeef(Integer meta, int count) {
        super(ItemID.COOKED_BEEF, meta, count, "Cooked Beef");
    }
}
