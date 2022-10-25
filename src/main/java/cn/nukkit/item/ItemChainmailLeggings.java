package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemChainmailLeggings extends ItemArmor {

    public ItemChainmailLeggings() {
        this(0, 1);
    }

    public ItemChainmailLeggings(Integer meta) {
        this(meta, 1);
    }

    public ItemChainmailLeggings(Integer meta, int count) {
        super(ItemID.CHAINMAIL_LEGGINGS, meta, count, "Chainmail Leggings");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_CHAIN;
    }

    @Override
    public boolean isLeggings() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 4;
    }

    @Override
    public int getMaxDurability() {
        return 226;
    }
}
