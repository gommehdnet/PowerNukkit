package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemStoneHoe extends ItemTool {

    public ItemStoneHoe() {
        this(0, 1);
    }

    public ItemStoneHoe(Integer meta) {
        this(meta, 1);
    }

    public ItemStoneHoe(Integer meta, int count) {
        super(ItemID.STONE_HOE, meta, count, "Stone Hoe");
    }

    @Override
    public int getMaxDurability() {
        return ItemTool.DURABILITY_STONE;
    }

    @Override
    public boolean isHoe() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_STONE;
    }
}
