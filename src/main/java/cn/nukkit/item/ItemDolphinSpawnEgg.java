package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityDolphin;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDolphinSpawnEgg extends ItemSpawnEgg {

    public ItemDolphinSpawnEgg() {
        this(0, 1);
    }

    public ItemDolphinSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemDolphinSpawnEgg(Integer meta, int count) {
        super(ItemID.DOLPHIN_SPAWN_EGG, meta, count, "Dolphin Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityDolphin.NETWORK_ID;
    }
}