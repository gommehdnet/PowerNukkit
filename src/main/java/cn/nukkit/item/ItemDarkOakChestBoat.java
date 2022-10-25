package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDarkOakChestBoat extends Item {

    public ItemDarkOakChestBoat() {
        this(0, 1);
    }

    public ItemDarkOakChestBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemDarkOakChestBoat(Integer meta, int count) {
        super(ItemID.DARK_OAK_CHEST_BOAT, meta, count, "Dark Oak Chest Boat");
    }
}