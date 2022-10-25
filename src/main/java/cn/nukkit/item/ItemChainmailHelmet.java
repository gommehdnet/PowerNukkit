package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemChainmailHelmet extends ItemArmor {

    public ItemChainmailHelmet() {
        this(0, 1);
    }

    public ItemChainmailHelmet(Integer meta) {
        this(meta, 1);
    }

    public ItemChainmailHelmet(Integer meta, int count) {
        super(ItemID.CHAINMAIL_HELMET, meta, count, "Chainmail Helmet");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_CHAIN;
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
