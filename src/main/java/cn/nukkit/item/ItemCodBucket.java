package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCodBucket extends Item {

    public ItemCodBucket() {
        this(0, 1);
    }

    public ItemCodBucket(Integer meta) {
        this(meta, 1);
    }

    public ItemCodBucket(Integer meta, int count) {
        super(ItemID.COD_BUCKET, meta, count, "Cod Bucket");
    }
}