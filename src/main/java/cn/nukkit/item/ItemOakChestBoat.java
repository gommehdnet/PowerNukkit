package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOakChestBoat extends Item {

    public ItemOakChestBoat() {
        this(0, 1);
    }

    public ItemOakChestBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemOakChestBoat(Integer meta, int count) {
        super(ItemID.OAK_CHEST_BOAT, meta, count, "Oak Chest Boat");
    }
}