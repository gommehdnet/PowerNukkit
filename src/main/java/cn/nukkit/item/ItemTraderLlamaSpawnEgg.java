package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTraderLlamaSpawnEgg extends Item {

    public ItemTraderLlamaSpawnEgg() {
        this(0, 1);
    }

    public ItemTraderLlamaSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemTraderLlamaSpawnEgg(Integer meta, int count) {
        super(ItemID.TRADER_LLAMA_SPAWN_EGG, meta, count, "Trader Llama Spawn Egg");
    }
}