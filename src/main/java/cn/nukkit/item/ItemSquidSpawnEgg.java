package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSquidSpawnEgg extends Item {

    public ItemSquidSpawnEgg() {
        this(0, 1);
    }

    public ItemSquidSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemSquidSpawnEgg(Integer meta, int count) {
        super(ItemID.SQUID_SPAWN_EGG, meta, count, "Squid Spawn Egg");
    }
}