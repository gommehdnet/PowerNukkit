package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemDiamondPickaxe extends ItemTool {

    public ItemDiamondPickaxe() {
        this(0, 1);
    }

    public ItemDiamondPickaxe(Integer meta) {
        this(meta, 1);
    }

    public ItemDiamondPickaxe(Integer meta, int count) {
        super(ItemID.DIAMOND_PICKAXE, meta, count, "Diamond Pickaxe");
    }

    @Override
    public int getMaxDurability() {
        return ItemTool.DURABILITY_DIAMOND;
    }

    @Override
    public boolean isPickaxe() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_DIAMOND;
    }

    @Override
    public int getAttackDamage() {
        return 5;
    }
}
