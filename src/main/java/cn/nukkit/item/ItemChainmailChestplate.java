package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemChainmailChestplate extends ItemArmor {

    public ItemChainmailChestplate() {
        this(0, 1);
    }

    public ItemChainmailChestplate(Integer meta) {
        this(meta, 1);
    }

    public ItemChainmailChestplate(Integer meta, int count) {
        super(ItemID.CHAINMAIL_CHESTPLATE, meta, count, "Chainmail Chestplate");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_CHAIN;
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
        return 241;
    }
}
