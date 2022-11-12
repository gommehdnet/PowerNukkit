package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityGlowSquid;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGlowSquidSpawnEgg extends ItemSpawnEgg {

    public ItemGlowSquidSpawnEgg() {
        this(0, 1);
    }

    public ItemGlowSquidSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemGlowSquidSpawnEgg(Integer meta, int count) {
        super(ItemID.GLOW_SQUID_SPAWN_EGG, meta, count, "Glow Squid Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityGlowSquid.NETWORK_ID;
    }
}