package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWanderingTraderSpawnEgg extends Item {

    public ItemWanderingTraderSpawnEgg() {
        this(0, 1);
    }

    public ItemWanderingTraderSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemWanderingTraderSpawnEgg(Integer meta, int count) {
        super(ItemID.WANDERING_TRADER_SPAWN_EGG, meta, count, "Wandering Trader Spawn Egg");
    }
}