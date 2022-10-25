package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemLeatherBoots extends ItemColorArmor {

    public ItemLeatherBoots() {
        this(0, 1);
    }

    public ItemLeatherBoots(Integer meta) {
        this(meta, 1);
    }

    public ItemLeatherBoots(Integer meta, int count) {
        super(ItemID.LEATHER_BOOTS, meta, count, "Leather Boots");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_LEATHER;
    }

    @Override
    public boolean isBoots() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 1;
    }

    @Override
    public int getMaxDurability() {
        return 66;
    }
}
