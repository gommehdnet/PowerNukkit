package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBleach extends Item {

    public ItemBleach() {
        this(0, 1);
    }

    public ItemBleach(Integer meta) {
        this(meta, 1);
    }

    public ItemBleach(Integer meta, int count) {
        super(ItemID.BLEACH, meta, count, "Bleach");
    }
}