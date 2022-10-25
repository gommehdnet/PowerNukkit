package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemDiamondAxe extends ItemTool {

    public ItemDiamondAxe() {
        this(0, 1);
    }

    public ItemDiamondAxe(Integer meta) {
        this(meta, 1);
    }

    public ItemDiamondAxe(Integer meta, int count) {
        super(ItemID.DIAMOND_AXE, meta, count, "Diamond Axe");
    }

    @Override
    public int getMaxDurability() {
        return ItemTool.DURABILITY_DIAMOND;
    }

    @Override
    public boolean isAxe() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_DIAMOND;
    }

    @Override
    public int getAttackDamage() {
        return 6;
    }
}
