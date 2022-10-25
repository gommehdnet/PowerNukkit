package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFoxSpawnEgg extends Item {

    public ItemFoxSpawnEgg() {
        this(0, 1);
    }

    public ItemFoxSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemFoxSpawnEgg(Integer meta, int count) {
        super(ItemID.FOX_SPAWN_EGG, meta, count, "Fox Spawn Egg");
    }
}