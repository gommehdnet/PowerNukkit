package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityTraderLlama;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTraderLlamaSpawnEgg extends ItemSpawnEgg {

    public ItemTraderLlamaSpawnEgg() {
        this(0, 1);
    }

    public ItemTraderLlamaSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemTraderLlamaSpawnEgg(Integer meta, int count) {
        super(ItemID.TRADER_LLAMA_SPAWN_EGG, meta, count, "Trader Llama Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityTraderLlama.NETWORK_ID;
    }
}