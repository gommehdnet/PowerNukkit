package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCodSpawnEgg extends Item {

    public ItemCodSpawnEgg() {
        this(0, 1);
    }

    public ItemCodSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemCodSpawnEgg(Integer meta, int count) {
        super(ItemID.COD_SPAWN_EGG, meta, count, "Cod Spawn Egg");
    }
}