package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTurtleSpawnEgg extends Item {

    public ItemTurtleSpawnEgg() {
        this(0, 1);
    }

    public ItemTurtleSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemTurtleSpawnEgg(Integer meta, int count) {
        super(ItemID.TURTLE_SPAWN_EGG, meta, count, "Turtle Spawn Egg");
    }
}