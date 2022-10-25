package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAxolotlBucket extends Item {

    public ItemAxolotlBucket() {
        this(0, 1);
    }

    public ItemAxolotlBucket(Integer meta) {
        this(meta, 1);
    }

    public ItemAxolotlBucket(Integer meta, int count) {
        super(ItemID.AXOLOTL_BUCKET, meta, count, "Axolotl Bucket");
    }
}