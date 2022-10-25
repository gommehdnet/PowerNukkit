package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemBakedPotato extends ItemEdible {

    public ItemBakedPotato() {
        this(0, 1);
    }

    public ItemBakedPotato(Integer meta) {
        this(meta, 1);
    }

    public ItemBakedPotato(Integer meta, int count) {
        super(ItemID.BAKED_POTATO, meta, count, "Baked Potato");
    }

}
