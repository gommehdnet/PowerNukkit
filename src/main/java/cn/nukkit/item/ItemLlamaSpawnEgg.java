package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLlamaSpawnEgg extends Item {

    public ItemLlamaSpawnEgg() {
        this(0, 1);
    }

    public ItemLlamaSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemLlamaSpawnEgg(Integer meta, int count) {
        super(ItemID.LLAMA_SPAWN_EGG, meta, count, "Llama Spawn Egg");
    }
}