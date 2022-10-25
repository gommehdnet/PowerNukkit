package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemStonePickaxe extends ItemTool {

    public ItemStonePickaxe() {
        this(0, 1);
    }

    public ItemStonePickaxe(Integer meta) {
        this(meta, 1);
    }

    public ItemStonePickaxe(Integer meta, int count) {
        super(ItemID.STONE_PICKAXE, meta, count, "Stone Pickaxe");
    }

    @Override
    public int getMaxDurability() {
        return ItemTool.DURABILITY_STONE;
    }

    @Override
    public boolean isPickaxe() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_STONE;
    }

    @Override
    public int getAttackDamage() {
        return 3;
    }
}
