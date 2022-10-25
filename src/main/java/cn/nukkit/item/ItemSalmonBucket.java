package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSalmonBucket extends Item {

    public ItemSalmonBucket() {
        this(0, 1);
    }

    public ItemSalmonBucket(Integer meta) {
        this(meta, 1);
    }

    public ItemSalmonBucket(Integer meta, int count) {
        super(ItemID.SALMON_BUCKET, meta, count, "Salmon Bucket");
    }
}