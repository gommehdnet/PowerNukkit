package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGlowStick extends Item {

    public ItemGlowStick() {
        this(0, 1);
    }

    public ItemGlowStick(Integer meta) {
        this(meta, 1);
    }

    public ItemGlowStick(Integer meta, int count) {
        super(ItemID.GLOW_STICK, meta, count, "Glow Stick");
    }
}