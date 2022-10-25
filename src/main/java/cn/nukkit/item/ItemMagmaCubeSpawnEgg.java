package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMagmaCubeSpawnEgg extends Item {

    public ItemMagmaCubeSpawnEgg() {
        this(0, 1);
    }

    public ItemMagmaCubeSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemMagmaCubeSpawnEgg(Integer meta, int count) {
        super(ItemID.MAGMA_CUBE_SPAWN_EGG, meta, count, "Magma Cube Spawn Egg");
    }
}