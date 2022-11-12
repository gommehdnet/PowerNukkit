package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntitySheep;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSheepSpawnEgg extends ItemSpawnEgg {

    public ItemSheepSpawnEgg() {
        this(0, 1);
    }

    public ItemSheepSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSheepSpawnEgg(Integer meta, int count) {
        super(ItemID.SHEEP_SPAWN_EGG, meta, count, "Sheep Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntitySheep.NETWORK_ID;
    }
}