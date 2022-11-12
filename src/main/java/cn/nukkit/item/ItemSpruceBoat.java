package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSpruceBoat extends ItemBoat {

    public ItemSpruceBoat() {
        this(0, 1);
    }

    public ItemSpruceBoat(Integer meta) {
        this(meta, 1);
    }

    public ItemSpruceBoat(Integer meta, int count) {
        super(ItemID.SPRUCE_BOAT, meta, count, "Spruce Boat");
        this.variant = 1;
    }
}