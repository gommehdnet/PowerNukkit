package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPufferfishBucket extends Item {

    public ItemPufferfishBucket() {
        this(0, 1);
    }

    public ItemPufferfishBucket(Integer meta) {
        this(meta, 1);
    }

    public ItemPufferfishBucket(Integer meta, int count) {
        super(ItemID.PUFFERFISH_BUCKET, meta, count, "Pufferfish Bucket");
    }
}