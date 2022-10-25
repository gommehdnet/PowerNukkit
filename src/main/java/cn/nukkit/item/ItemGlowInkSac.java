package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGlowInkSac extends Item {

    public ItemGlowInkSac() {
        this(0, 1);
    }

    public ItemGlowInkSac(Integer meta) {
        this(meta, 1);
    }

    public ItemGlowInkSac(Integer meta, int count) {
        super(ItemID.GLOW_INK_SAC, meta, count, "Glow Ink Sac");
    }
}