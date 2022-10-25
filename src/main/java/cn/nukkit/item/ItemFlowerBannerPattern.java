package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFlowerBannerPattern extends Item {

    public ItemFlowerBannerPattern() {
        this(0, 1);
    }

    public ItemFlowerBannerPattern(Integer meta) {
        this(meta, 1);
    }

    public ItemFlowerBannerPattern(Integer meta, int count) {
        super(ItemID.FLOWER_BANNER_PATTERN, meta, count, "Flower Banner Pattern");
    }
}