package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityLlama;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLlamaSpawnEgg extends ItemSpawnEgg {

    public ItemLlamaSpawnEgg() {
        this(0, 1);
    }

    public ItemLlamaSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemLlamaSpawnEgg(Integer meta, int count) {
        super(ItemID.LLAMA_SPAWN_EGG, meta, count, "Llama Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityLlama.NETWORK_ID;
    }
}