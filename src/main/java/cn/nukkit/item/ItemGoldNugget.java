package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemGoldNugget extends Item {

    public ItemGoldNugget() {
        this(0, 1);
    }

    public ItemGoldNugget(Integer meta) {
        this(meta, 1);
    }

    public ItemGoldNugget(Integer meta, int count) {
        super(ItemID.GOLD_NUGGET, meta, count, "Gold Nugget");
    }
}
