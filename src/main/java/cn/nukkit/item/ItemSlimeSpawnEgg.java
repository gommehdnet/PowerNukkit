package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSlimeSpawnEgg extends Item {

    public ItemSlimeSpawnEgg() {
        this(0, 1);
    }

    public ItemSlimeSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSlimeSpawnEgg(Integer meta, int count) {
        super(ItemID.SLIME_SPAWN_EGG, meta, count, "Slime Spawn Egg");
    }
}