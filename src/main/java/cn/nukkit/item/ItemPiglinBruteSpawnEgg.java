package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityPiglinBrute;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPiglinBruteSpawnEgg extends ItemSpawnEgg {

    public ItemPiglinBruteSpawnEgg() {
        this(0, 1);
    }

    public ItemPiglinBruteSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemPiglinBruteSpawnEgg(Integer meta, int count) {
        super(ItemID.PIGLIN_BRUTE_SPAWN_EGG, meta, count, "Piglin Brute Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityPiglinBrute.NETWORK_ID;
    }
}