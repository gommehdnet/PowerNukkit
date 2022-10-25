package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEndermanSpawnEgg extends Item {

    public ItemEndermanSpawnEgg() {
        this(0, 1);
    }

    public ItemEndermanSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemEndermanSpawnEgg(Integer meta, int count) {
        super(ItemID.ENDERMAN_SPAWN_EGG, meta, count, "Enderman Spawn Egg");
    }
}