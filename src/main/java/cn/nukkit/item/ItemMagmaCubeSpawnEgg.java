package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityMagmaCube;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMagmaCubeSpawnEgg extends ItemSpawnEgg {

    public ItemMagmaCubeSpawnEgg() {
        this(0, 1);
    }

    public ItemMagmaCubeSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemMagmaCubeSpawnEgg(Integer meta, int count) {
        super(ItemID.MAGMA_CUBE_SPAWN_EGG, meta, count, "Magma Cube Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityMagmaCube.NETWORK_ID;
    }
}