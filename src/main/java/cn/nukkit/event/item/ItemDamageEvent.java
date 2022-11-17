package cn.nukkit.event.item;

import cn.nukkit.event.Cancellable;
import cn.nukkit.event.Event;
import cn.nukkit.event.HandlerList;
import cn.nukkit.item.Item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDamageEvent extends Event implements Cancellable {

    public static final HandlerList handlers = new HandlerList();

    private final Item item;

    public ItemDamageEvent(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return this.item;
    }

    public static HandlerList getHandlers() {
        return ItemDamageEvent.handlers;
    }
}