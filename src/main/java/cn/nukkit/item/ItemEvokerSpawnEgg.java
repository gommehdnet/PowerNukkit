package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEvokerSpawnEgg extends Item {

    public ItemEvokerSpawnEgg() {
        this(0, 1);
    }

    public ItemEvokerSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemEvokerSpawnEgg(Integer meta, int count) {
        super(ItemID.EVOKER_SPAWN_EGG, meta, count, "Evoker Spawn Egg");
    }
}