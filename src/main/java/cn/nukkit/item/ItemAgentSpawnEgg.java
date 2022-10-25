package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAgentSpawnEgg extends Item {

    public ItemAgentSpawnEgg() {
        this(0, 1);
    }

    public ItemAgentSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemAgentSpawnEgg(Integer meta, int count) {
        super(ItemID.AGENT_SPAWN_EGG, meta, count, "Agent Spawn Egg");
    }
}