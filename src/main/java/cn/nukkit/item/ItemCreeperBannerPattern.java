package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCreeperBannerPattern extends Item {

    public ItemCreeperBannerPattern() {
        this(0, 1);
    }

    public ItemCreeperBannerPattern(Integer meta) {
        this(meta, 1);
    }

    public ItemCreeperBannerPattern(Integer meta, int count) {
        super(ItemID.CREEPER_BANNER_PATTERN, meta, count, "Creeper Banner Pattern");
    }
}