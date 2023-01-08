package cn.nukkit.event.entity;

import cn.nukkit.entity.EntityLiving;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.item.Item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class EntityWillDieEvent extends EntityEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    public EntityWillDieEvent(EntityLiving entity) {
        this.entity = entity;
    }

}
