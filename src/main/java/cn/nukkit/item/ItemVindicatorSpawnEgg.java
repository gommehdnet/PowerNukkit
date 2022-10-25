package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemVindicatorSpawnEgg extends Item {

    public ItemVindicatorSpawnEgg() {
        this(0, 1);
    }

    public ItemVindicatorSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemVindicatorSpawnEgg(Integer meta, int count) {
        super(ItemID.VINDICATOR_SPAWN_EGG, meta, count, "Vindicator Spawn Egg");
    }
}