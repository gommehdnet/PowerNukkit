package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemBeef extends ItemEdible {

    public ItemBeef() {
        this(0, 1);
    }

    public ItemBeef(Integer meta) {
        this(meta, 1);
    }

    public ItemBeef(Integer meta, int count) {
        super(ItemID.BEEF, meta, count, "Raw Beef");
    }
}
