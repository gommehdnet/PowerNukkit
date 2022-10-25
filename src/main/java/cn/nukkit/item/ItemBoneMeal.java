package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBoneMeal extends Item {

    public ItemBoneMeal() {
        this(0, 1);
    }

    public ItemBoneMeal(Integer meta) {
        this(meta, 1);
    }

    public ItemBoneMeal(Integer meta, int count) {
        super(ItemID.BONE_MEAL, meta, count, "Bone Meal");
    }
}