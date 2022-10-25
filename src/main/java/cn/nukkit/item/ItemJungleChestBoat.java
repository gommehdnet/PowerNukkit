package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemJungleChestBoat extends Item {

    public ItemJungleChestBoat() {
        this(0, 1);
    }

    public ItemJungleChestBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemJungleChestBoat(Integer meta, int count) {
        super(ItemID.JUNGLE_CHEST_BOAT, meta, count, "Jungle Chest Boat");
    }
}