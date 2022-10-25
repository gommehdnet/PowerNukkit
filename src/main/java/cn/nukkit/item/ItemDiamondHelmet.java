package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemDiamondHelmet extends ItemArmor {

    public ItemDiamondHelmet() {
        this(0, 1);
    }

    public ItemDiamondHelmet(Integer meta) {
        this(meta, 1);
    }

    public ItemDiamondHelmet(Integer meta, int count) {
        super(ItemID.DIAMOND_HELMET, meta, count, "Diamond Helmet");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_DIAMOND;
    }

    @Override
    public boolean isHelmet() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 3;
    }

    @Override
    public int getMaxDurability() {
        return 364;
    }

    @Override
    public int getToughness() {
        return 2;
    }
}
