package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.entity.passive.EntityTurtle;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTurtleSpawnEgg extends ItemSpawnEgg {

    public ItemTurtleSpawnEgg() {
        this(0, 1);
    }

    public ItemTurtleSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemTurtleSpawnEgg(Integer meta, int count) {
        super(ItemID.TURTLE_SPAWN_EGG, meta, count, "Turtle Spawn Egg");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getEntityNetworkId() {
        return EntityTurtle.NETWORK_ID;
    }
}