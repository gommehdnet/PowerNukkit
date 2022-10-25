package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMedicine extends Item {

    public ItemMedicine() {
        this(0, 1);
    }

    public ItemMedicine(Integer meta) {
        this(meta, 1);
    }

    public ItemMedicine(Integer meta, int count) {
        super(ItemID.MEDICINE, meta, count, "Medicine");
    }
}