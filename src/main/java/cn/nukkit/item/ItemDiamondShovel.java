package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemDiamondShovel extends ItemTool {

    public ItemDiamondShovel() {
        this(0, 1);
    }

    public ItemDiamondShovel(Integer meta) {
        this(meta, 1);
    }

    public ItemDiamondShovel(Integer meta, int count) {
        super(ItemID.DIAMOND_SHOVEL, meta, count, "Diamond Shovel");
    }

    @Override
    public int getMaxDurability() {
        return ItemTool.DURABILITY_DIAMOND;
    }

    @Override
    public boolean isShovel() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_DIAMOND;
    }

    @Override
    public int getAttackDamage() {
        return 4;
    }
}
