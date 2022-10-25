package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemDiamondLeggings extends ItemArmor {

    public ItemDiamondLeggings() {
        this(0, 1);
    }

    public ItemDiamondLeggings(Integer meta) {
        this(meta, 1);
    }

    public ItemDiamondLeggings(Integer meta, int count) {
        super(ItemID.DIAMOND_LEGGINGS, meta, count, "Diamond Leggings");
    }

    @Override
    public boolean isLeggings() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_DIAMOND;
    }

    @Override
    public int getArmorPoints() {
        return 6;
    }

    @Override
    public int getMaxDurability() {
        return 496;
    }

    @Override
    public int getToughness() {
        return 2;
    }
}
