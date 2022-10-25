package cn.nukkit.item;

/**
 * @author Snake1999
 * @since 2016/1/14
 */
public class ItemCookedRabbit extends ItemEdible {

    public ItemCookedRabbit() {
        this(0, 1);
    }

    public ItemCookedRabbit(Integer meta) {
        this(meta, 1);
    }

    public ItemCookedRabbit(Integer meta, int count) {
        super(ItemID.COOKED_RABBIT, meta, count, "Cooked Rabbit");
    }
}
