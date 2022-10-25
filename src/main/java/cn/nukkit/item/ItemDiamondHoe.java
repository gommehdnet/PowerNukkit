package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemDiamondHoe extends ItemTool {

    public ItemDiamondHoe() {
        this(0, 1);
    }

    public ItemDiamondHoe(Integer meta) {
        this(meta, 1);
    }

    public ItemDiamondHoe(Integer meta, int count) {
        super(ItemID.DIAMOND_HOE, meta, count, "Diamond Hoe");
    }

    @Override
    public int getMaxDurability() {
        return ItemTool.DURABILITY_DIAMOND;
    }

    @Override
    public boolean isHoe() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_DIAMOND;
    }
}
