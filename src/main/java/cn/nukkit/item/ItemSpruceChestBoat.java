package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSpruceChestBoat extends Item {

    public ItemSpruceChestBoat() {
        this(0, 1);
    }

    public ItemSpruceChestBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemSpruceChestBoat(Integer meta, int count) {
        super(ItemID.SPRUCE_CHEST_BOAT, meta, count, "Spruce Chest Boat");
    }
}