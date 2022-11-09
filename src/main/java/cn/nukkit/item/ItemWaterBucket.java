package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaterBucket extends ItemBucket {

    public ItemWaterBucket() {
        this(0, 1);
    }

    public ItemWaterBucket(Integer meta) {
        this(meta, 1);
    }

    public ItemWaterBucket(Integer meta, int count) {
        super(ItemID.WATER_BUCKET, count, "Water Bucket");
    }
}