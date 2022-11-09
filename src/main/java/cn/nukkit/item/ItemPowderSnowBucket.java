package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPowderSnowBucket extends ItemBucket {

    public ItemPowderSnowBucket() {
        this(0, 1);
    }

    public ItemPowderSnowBucket(Integer meta) {
        this(meta, 1);
    }

    public ItemPowderSnowBucket(Integer meta, int count) {
        super(ItemID.POWDER_SNOW_BUCKET, count, "Powder Snow Bucket");
    }
}