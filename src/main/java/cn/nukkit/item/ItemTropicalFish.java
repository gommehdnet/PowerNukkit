package cn.nukkit.item;

/**
 * @author Snake1999
 * @since 2016/1/14
 */
public class ItemTropicalFish extends ItemCod {

    public ItemTropicalFish() {
        this(0, 1);
    }

    public ItemTropicalFish(Integer meta) {
        this(meta, 1);
    }

    public ItemTropicalFish(Integer meta, int count) {
        super(ItemID.TROPICAL_FISH, meta, count, "Tropical Fish");
    }
}
