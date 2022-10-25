package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPiglinBannerPattern extends Item {

    public ItemPiglinBannerPattern() {
        this(0, 1);
    }

    public ItemPiglinBannerPattern(Integer meta) {
        this(meta, 1);
    }

    public ItemPiglinBannerPattern(Integer meta, int count) {
        super(ItemID.PIGLIN_BANNER_PATTERN, meta, count, "Piglin Banner Pattern");
    }
}