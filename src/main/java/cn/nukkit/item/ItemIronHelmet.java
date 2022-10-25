package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemIronHelmet extends ItemArmor {

    public ItemIronHelmet() {
        this(0, 1);
    }

    public ItemIronHelmet(Integer meta) {
        this(meta, 1);
    }

    public ItemIronHelmet(Integer meta, int count) {
        super(ItemID.IRON_HELMET, meta, count, "Iron Helmet");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_IRON;
    }

    @Override
    public boolean isHelmet() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 2;
    }

    @Override
    public int getMaxDurability() {
        return 166;
    }
}
