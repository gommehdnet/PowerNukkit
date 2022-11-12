package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityNPCEntity;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemNpcSpawnEgg extends ItemSpawnEgg {

    public ItemNpcSpawnEgg() {
        this(0, 1);
    }

    public ItemNpcSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemNpcSpawnEgg(Integer meta, int count) {
        super(ItemID.NPC_SPAWN_EGG, meta, count, "Npc Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityNPCEntity.NETWORK_ID;
    }
}