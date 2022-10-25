package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMojangBannerPattern extends Item {

    public ItemMojangBannerPattern() {
        this(0, 1);
    }

    public ItemMojangBannerPattern(Integer meta) {
        this(meta, 1);
    }

    public ItemMojangBannerPattern(Integer meta, int count) {
        super(ItemID.MOJANG_BANNER_PATTERN, meta, count, "Mojang Banner Pattern");
    }
}