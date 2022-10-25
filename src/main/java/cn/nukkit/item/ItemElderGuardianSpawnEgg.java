package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemElderGuardianSpawnEgg extends Item {

    public ItemElderGuardianSpawnEgg() {
        this(0, 1);
    }

    public ItemElderGuardianSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemElderGuardianSpawnEgg(Integer meta, int count) {
        super(ItemID.ELDER_GUARDIAN_SPAWN_EGG, meta, count, "Elder Guardian Spawn Egg");
    }
}