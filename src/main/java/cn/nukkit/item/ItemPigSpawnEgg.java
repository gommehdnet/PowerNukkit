package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityPig;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPigSpawnEgg extends ItemSpawnEgg {

    public ItemPigSpawnEgg() {
        this(0, 1);
    }

    public ItemPigSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPigSpawnEgg(Integer meta, int count) {
        super(ItemID.PIG_SPAWN_EGG, meta, count, "Pig Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityPig.NETWORK_ID;
    }
}