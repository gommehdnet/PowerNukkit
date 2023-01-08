package cn.nukkit.event.inventory;

import cn.nukkit.Player;
import cn.nukkit.event.Cancellable;
import cn.nukkit.event.HandlerList;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.item.Item;

/**
 * @author boybook (Nukkit Project)
 */
public class InventoryClickEvent extends InventoryEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private final int slot;
    private final Item sourceItem;
    private final Item heldItem;
    private final Player player;
    private final Inventory destinationInventory;
    private final int destinationSlot;

    public InventoryClickEvent(Player who, Inventory inventory, Inventory destinationInventory, int slot, int destinationSlot, Item sourceItem, Item heldItem) {
        super(inventory);
        this.destinationInventory = destinationInventory;
        this.slot = slot;
        this.sourceItem = sourceItem;
        this.heldItem = heldItem;
        this.player = who;
        this.destinationSlot = destinationSlot;
    }

    public int getSlot() {
        return slot;
    }

    public Item getSourceItem() {
        return sourceItem;
    }

    public Item getHeldItem() {
        return heldItem;
    }

    public Player getPlayer() {
        return player;
    }

    public Inventory getDestinationInventory() {
        return this.destinationInventory;
    }

    public int getDestinationSlot() {
        return this.destinationSlot;
    }
}