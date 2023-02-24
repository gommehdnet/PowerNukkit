package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;

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

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public boolean isFertilizer() {
        return true;
    }
}