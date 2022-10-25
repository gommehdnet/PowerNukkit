package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemPorkchop extends ItemEdible {

    public ItemPorkchop() {
        this(0, 1);
    }

    public ItemPorkchop(Integer meta) {
        this(meta, 1);
    }

    public ItemPorkchop(Integer meta, int count) {
        super(ItemID.PORKCHOP, meta, count, "Raw Porkchop");
    }
}
