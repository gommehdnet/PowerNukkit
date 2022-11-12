package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityBat;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBatSpawnEgg extends ItemSpawnEgg {

    public ItemBatSpawnEgg() {
        this(0, 1);
    }

    public ItemBatSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemBatSpawnEgg(Integer meta, int count) {
        super(ItemID.BAT_SPAWN_EGG, meta, count, "Bat Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityBat.NETWORK_ID;
    }
}