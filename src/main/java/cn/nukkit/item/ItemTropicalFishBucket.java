package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTropicalFishBucket extends ItemBucket {

    public ItemTropicalFishBucket() {
        this(0, 1);
    }

    public ItemTropicalFishBucket(Integer meta) {
        this(meta, 1);
    }

    public ItemTropicalFishBucket(Integer meta, int count) {
        super(ItemID.TROPICAL_FISH_BUCKET, count, "Tropical Fish Bucket");
    }
}