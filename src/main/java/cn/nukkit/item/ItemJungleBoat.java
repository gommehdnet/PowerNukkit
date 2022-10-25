package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemJungleBoat extends Item {

    public ItemJungleBoat() {
        this(0, 1);
    }

    public ItemJungleBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemJungleBoat(Integer meta, int count) {
        super(ItemID.JUNGLE_BOAT, meta, count, "Jungle Boat");
    }
}