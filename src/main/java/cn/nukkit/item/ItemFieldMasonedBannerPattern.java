package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFieldMasonedBannerPattern extends Item {

    public ItemFieldMasonedBannerPattern() {
        this(0, 1);
    }

    public ItemFieldMasonedBannerPattern(Integer meta) {
        this(meta, 1);
    }

    public ItemFieldMasonedBannerPattern(Integer meta, int count) {
        super(ItemID.FIELD_MASONED_BANNER_PATTERN, meta, count, "Field Masoned Banner Pattern");
    }
}