package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTropicalFishBucket extends Item {

    public ItemTropicalFishBucket() {
        this(0, 1);
    }

    public ItemTropicalFishBucket(Integer meta) {
        this(meta, 1);
    }

    public ItemTropicalFishBucket(Integer meta, int count) {
        super(ItemID.TROPICAL_FISH_BUCKET, meta, count, "Tropical Fish Bucket");
    }
}