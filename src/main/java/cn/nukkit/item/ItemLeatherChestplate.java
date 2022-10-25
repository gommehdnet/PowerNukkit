package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemLeatherChestplate extends ItemColorArmor {

    public ItemLeatherChestplate() {
        this(0, 1);
    }

    public ItemLeatherChestplate(Integer meta) {
        this(meta, 1);
    }

    public ItemLeatherChestplate(Integer meta, int count) {
        super(ItemID.LEATHER_CHESTPLATE, meta, count, "Leather Tunic");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_LEATHER;
    }

    @Override
    public boolean isChestplate() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 3;
    }

    @Override
    public int getMaxDurability() {
        return 81;
    }
}
