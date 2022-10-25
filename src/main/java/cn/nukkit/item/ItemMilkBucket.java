package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMilkBucket extends Item {

    public ItemMilkBucket() {
        this(0, 1);
    }

    public ItemMilkBucket(Integer meta) {
        this(meta, 1);
    }

    public ItemMilkBucket(Integer meta, int count) {
        super(ItemID.MILK_BUCKET, meta, count, "Milk Bucket");
    }
}