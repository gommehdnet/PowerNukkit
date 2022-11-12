package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityAxolotl;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAxolotlSpawnEgg extends ItemSpawnEgg {

    public ItemAxolotlSpawnEgg() {
        this(0, 1);
    }

    public ItemAxolotlSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemAxolotlSpawnEgg(Integer meta, int count) {
        super(ItemID.AXOLOTL_SPAWN_EGG, meta, count, "Axolotl Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityAxolotl.NETWORK_ID;
    }
}