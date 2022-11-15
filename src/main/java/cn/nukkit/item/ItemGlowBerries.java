package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGlowBerries extends ItemEdible {

    public ItemGlowBerries() {
        this(0, 1);
    }

    public ItemGlowBerries(Integer meta) {
        this(meta, 1);
    }

    public ItemGlowBerries(Integer meta, int count) {
        super(ItemID.GLOW_BERRIES, meta, count, "Glow Berries");
    }
}