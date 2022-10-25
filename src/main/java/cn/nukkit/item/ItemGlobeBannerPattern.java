package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGlobeBannerPattern extends Item {

    public ItemGlobeBannerPattern() {
        this(0, 1);
    }

    public ItemGlobeBannerPattern(Integer meta) {
        this(meta, 1);
    }

    public ItemGlobeBannerPattern(Integer meta, int count) {
        super(ItemID.GLOBE_BANNER_PATTERN, meta, count, "Globe Banner Pattern");
    }
}