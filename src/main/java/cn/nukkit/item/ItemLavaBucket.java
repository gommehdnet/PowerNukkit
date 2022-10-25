package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLavaBucket extends Item {

    public ItemLavaBucket() {
        this(0, 1);
    }

    public ItemLavaBucket(Integer meta) {
        this(meta, 1);
    }

    public ItemLavaBucket(Integer meta, int count) {
        super(ItemID.LAVA_BUCKET, meta, count, "Lava Bucket");
    }
}