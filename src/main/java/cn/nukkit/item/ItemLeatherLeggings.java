package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLeatherLeggings extends ItemColorArmor {

    public ItemLeatherLeggings() {
        this(0, 1);
    }

    public ItemLeatherLeggings(Integer meta) {
        this(meta, 1);
    }

    public ItemLeatherLeggings(Integer meta, int count) {
        super(ItemID.LEATHER_LEGGINGS, meta, count, "Leather Leggings");
    }

    @Override
    public int getTier() {
        return TIER_LEATHER;
    }

    @Override
    public boolean isLeggings() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 2;
    }

    @Override
    public int getMaxDurability() {
        return 75;
    }
}