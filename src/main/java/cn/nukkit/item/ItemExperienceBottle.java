package cn.nukkit.item;

/**
 * @author xtypr
 * @since 2015/12/25
 */
public class ItemExperienceBottle extends ProjectileItem {

    public ItemExperienceBottle() {
        this(0, 1);
    }

    public ItemExperienceBottle(Integer meta) {
        this(meta, 1);
    }

    public ItemExperienceBottle(Integer meta, int count) {
        super(ItemID.EXPERIENCE_BOTTLE, meta, count, "Bottle o' Enchanting");
    }

    @Override
    public String getProjectileEntityType() {
        return "ThrownExpBottle";
    }

    @Override
    public float getThrowForce() {
        return 1f;
    }

}
