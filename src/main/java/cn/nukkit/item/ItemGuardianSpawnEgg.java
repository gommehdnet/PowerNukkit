package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGuardianSpawnEgg extends Item {

    public ItemGuardianSpawnEgg() {
        this(0, 1);
    }

    public ItemGuardianSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemGuardianSpawnEgg(Integer meta, int count) {
        super(ItemID.GUARDIAN_SPAWN_EGG, meta, count, "Guardian Spawn Egg");
    }
}