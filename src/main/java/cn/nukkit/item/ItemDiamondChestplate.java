package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemDiamondChestplate extends ItemArmor {

    public ItemDiamondChestplate() {
        this(0, 1);
    }

    public ItemDiamondChestplate(Integer meta) {
        this(meta, 1);
    }

    public ItemDiamondChestplate(Integer meta, int count) {
        super(ItemID.DIAMOND_CHESTPLATE, meta, count, "Diamond Chestplate");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_DIAMOND;
    }

    @Override
    public boolean isChestplate() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 8;
    }

    @Override
    public int getMaxDurability() {
        return 529;
    }

    @Override
    public int getToughness() {
        return 2;
    }
}
