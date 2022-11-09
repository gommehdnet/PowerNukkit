package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSalmonBucket extends ItemBucket {

    public ItemSalmonBucket() {
        this(0, 1);
    }

    public ItemSalmonBucket(Integer meta) {
        this(meta, 1);
    }

    public ItemSalmonBucket(Integer meta, int count) {
        super(ItemID.SALMON_BUCKET, count, "Salmon Bucket");
    }
}