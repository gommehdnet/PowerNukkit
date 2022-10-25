package cn.nukkit.item;

import cn.nukkit.api.Since;

/**
 * @author good777LUCKY
 */
@Since("1.4.0.0-PN")
public class ItemIronNugget extends Item {

    @Since("1.4.0.0-PN")
    public ItemIronNugget() {
        this(0, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemIronNugget(Integer meta) {
        this(meta, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemIronNugget(Integer meta, int count) {
        super(ItemID.IRON_NUGGET, meta, count, "Iron Nugget");
    }
}
