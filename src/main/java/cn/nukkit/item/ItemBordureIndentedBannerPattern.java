package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBordureIndentedBannerPattern extends Item {

    public ItemBordureIndentedBannerPattern() {
        this(0, 1);
    }

    public ItemBordureIndentedBannerPattern(Integer meta) {
        this(meta, 1);
    }

    public ItemBordureIndentedBannerPattern(Integer meta, int count) {
        super(ItemID.BORDURE_INDENTED_BANNER_PATTERN, meta, count, "Bordure Indented Banner Pattern");
    }
}