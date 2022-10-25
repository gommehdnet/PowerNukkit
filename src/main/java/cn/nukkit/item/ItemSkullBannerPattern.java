package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSkullBannerPattern extends Item {

    public ItemSkullBannerPattern() {
        this(0, 1);
    }

    public ItemSkullBannerPattern(Integer meta) {
        this(meta, 1);
    }

    public ItemSkullBannerPattern(Integer meta, int count) {
        super(ItemID.SKULL_BANNER_PATTERN, meta, count, "Skull Banner Pattern");
    }
}