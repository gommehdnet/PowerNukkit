package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRapidFertilizer extends Item {

    public ItemRapidFertilizer() {
        this(0, 1);
    }

    public ItemRapidFertilizer(Integer meta) {
        this(meta, 1);
    }

    public ItemRapidFertilizer(Integer meta, int count) {
        super(ItemID.RAPID_FERTILIZER, meta, count, "Rapid Fertilizer");
    }
}