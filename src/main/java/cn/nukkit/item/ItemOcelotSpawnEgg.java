package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOcelotSpawnEgg extends Item {

    public ItemOcelotSpawnEgg() {
        this(0, 1);
    }

    public ItemOcelotSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemOcelotSpawnEgg(Integer meta, int count) {
        super(ItemID.OCELOT_SPAWN_EGG, meta, count, "Ocelot Spawn Egg");
    }
}