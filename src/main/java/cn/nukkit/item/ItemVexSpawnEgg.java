package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemVexSpawnEgg extends Item {

    public ItemVexSpawnEgg() {
        this(0, 1);
    }

    public ItemVexSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemVexSpawnEgg(Integer meta, int count) {
        super(ItemID.VEX_SPAWN_EGG, meta, count, "Vex Spawn Egg");
    }
}