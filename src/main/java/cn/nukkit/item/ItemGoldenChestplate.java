package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemGoldenChestplate extends ItemArmor {

    public ItemGoldenChestplate() {
        this(0, 1);
    }

    public ItemGoldenChestplate(Integer meta) {
        this(meta, 1);
    }

    public ItemGoldenChestplate(Integer meta, int count) {
        super(ItemID.GOLDEN_CHESTPLATE, meta, count, "Golden Chestplate");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_GOLD;
    }

    @Override
    public boolean isChestplate() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 5;
    }

    @Override
    public int getMaxDurability() {
        return 113;
    }
}
