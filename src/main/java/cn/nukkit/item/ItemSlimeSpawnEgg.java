package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntitySlime;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSlimeSpawnEgg extends ItemSpawnEgg {

    public ItemSlimeSpawnEgg() {
        this(0, 1);
    }

    public ItemSlimeSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSlimeSpawnEgg(Integer meta, int count) {
        super(ItemID.SLIME_SPAWN_EGG, meta, count, "Slime Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntitySlime.NETWORK_ID;
    }
}