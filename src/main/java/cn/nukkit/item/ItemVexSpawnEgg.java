package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityVex;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemVexSpawnEgg extends ItemSpawnEgg {

    public ItemVexSpawnEgg() {
        this(0, 1);
    }

    public ItemVexSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemVexSpawnEgg(Integer meta, int count) {
        super(ItemID.VEX_SPAWN_EGG, meta, count, "Vex Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityVex.NETWORK_ID;
    }
}