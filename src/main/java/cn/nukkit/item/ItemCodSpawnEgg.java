package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityCod;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCodSpawnEgg extends ItemSpawnEgg {

    public ItemCodSpawnEgg() {
        this(0, 1);
    }

    public ItemCodSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemCodSpawnEgg(Integer meta, int count) {
        super(ItemID.COD_SPAWN_EGG, meta, count, "Cod Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityCod.NETWORK_ID;
    }
}