package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.mob.EntityRavager;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRavagerSpawnEgg extends ItemSpawnEgg {

    public ItemRavagerSpawnEgg() {
        this(0, 1);
    }

    public ItemRavagerSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemRavagerSpawnEgg(Integer meta, int count) {
        super(ItemID.RAVAGER_SPAWN_EGG, meta, count, "Ravager Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityRavager.NETWORK_ID;
    }
}