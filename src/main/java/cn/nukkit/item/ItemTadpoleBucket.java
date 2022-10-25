package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTadpoleBucket extends Item {

    public ItemTadpoleBucket() {
        this(0, 1);
    }

    public ItemTadpoleBucket(Integer meta) {
        this(meta, 1);
    }

    public ItemTadpoleBucket(Integer meta, int count) {
        super(ItemID.TADPOLE_BUCKET, meta, count, "Tadpole Bucket");
    }
}