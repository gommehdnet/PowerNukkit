package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityEnderman;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEndermanSpawnEgg extends ItemSpawnEgg {

    public ItemEndermanSpawnEgg() {
        this(0, 1);
    }

    public ItemEndermanSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemEndermanSpawnEgg(Integer meta, int count) {
        super(ItemID.ENDERMAN_SPAWN_EGG, meta, count, "Enderman Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityEnderman.NETWORK_ID;
    }
}