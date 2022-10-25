package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemNpcSpawnEgg extends Item {

    public ItemNpcSpawnEgg() {
        this(0, 1);
    }

    public ItemNpcSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemNpcSpawnEgg(Integer meta, int count) {
        super(ItemID.NPC_SPAWN_EGG, meta, count, "Npc Spawn Egg");
    }
}