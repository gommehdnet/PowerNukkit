package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityWanderingTrader;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWanderingTraderSpawnEgg extends ItemSpawnEgg {

    public ItemWanderingTraderSpawnEgg() {
        this(0, 1);
    }

    public ItemWanderingTraderSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemWanderingTraderSpawnEgg(Integer meta, int count) {
        super(ItemID.WANDERING_TRADER_SPAWN_EGG, meta, count, "Wandering Trader Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityWanderingTrader.NETWORK_ID;
    }
}