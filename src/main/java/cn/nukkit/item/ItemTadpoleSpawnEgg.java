package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTadpoleSpawnEgg extends Item {

    public ItemTadpoleSpawnEgg() {
        this(0, 1);
    }

    public ItemTadpoleSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemTadpoleSpawnEgg(Integer meta, int count) {
        super(ItemID.TADPOLE_SPAWN_EGG, meta, count, "Tadpole Spawn Egg");
    }
}