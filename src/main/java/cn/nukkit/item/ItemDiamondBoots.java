package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemDiamondBoots extends ItemArmor {

    public ItemDiamondBoots() {
        this(0, 1);
    }

    public ItemDiamondBoots(Integer meta) {
        this(meta, 1);
    }

    public ItemDiamondBoots(Integer meta, int count) {
        super(ItemID.DIAMOND_BOOTS, meta, count, "Diamond Boots");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_DIAMOND;
    }

    @Override
    public boolean isBoots() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 3;
    }

    @Override
    public int getMaxDurability() {
        return 430;
    }

    @Override
    public int getToughness() {
        return 2;
    }
}
