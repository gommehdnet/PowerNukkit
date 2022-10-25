package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemChainmailBoots extends ItemArmor {

    public ItemChainmailBoots() {
        this(0, 1);
    }

    public ItemChainmailBoots(Integer meta) {
        this(meta, 1);
    }

    public ItemChainmailBoots(Integer meta, int count) {
        super(ItemID.CHAINMAIL_BOOTS, meta, count, "Chainmail Boots");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_CHAIN;
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
        return 196;
    }
}
