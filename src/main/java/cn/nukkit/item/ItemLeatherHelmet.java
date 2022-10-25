package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemLeatherHelmet extends ItemColorArmor {

    public ItemLeatherHelmet() {
        this(0, 1);
    }

    public ItemLeatherHelmet(Integer meta) {
        this(meta, 1);
    }

    public ItemLeatherHelmet(Integer meta, int count) {
        super(ItemID.LEATHER_HELMET, meta, count, "Leather Cap");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_LEATHER;
    }

    @Override
    public boolean isHelmet() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 1;
    }

    @Override
    public int getMaxDurability() {
        return 56;
    }
}
