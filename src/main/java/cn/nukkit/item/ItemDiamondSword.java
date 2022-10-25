package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemDiamondSword extends ItemTool {

    public ItemDiamondSword() {
        this(0, 1);
    }

    public ItemDiamondSword(Integer meta) {
        this(meta, 1);
    }

    public ItemDiamondSword(Integer meta, int count) {
        super(ItemID.DIAMOND_SWORD, meta, count, "Diamond Sword");
    }

    @Override
    public int getMaxDurability() {
        return ItemTool.DURABILITY_DIAMOND;
    }

    @Override
    public boolean isSword() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_DIAMOND;
    }

    @Override
    public int getAttackDamage() {
        return 7;
    }
}
