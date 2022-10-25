package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAcaciaChestBoat extends Item {

    public ItemAcaciaChestBoat() {
        this(0, 1);
    }

    public ItemAcaciaChestBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemAcaciaChestBoat(Integer meta, int count) {
        super(ItemID.ACACIA_CHEST_BOAT, meta, count, "Acacia Chest Boat");
    }
}