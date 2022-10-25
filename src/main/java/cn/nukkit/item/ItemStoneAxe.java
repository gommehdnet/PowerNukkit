package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemStoneAxe extends ItemTool {

    public ItemStoneAxe() {
        this(0, 1);
    }

    public ItemStoneAxe(Integer meta) {
        this(meta, 1);
    }

    public ItemStoneAxe(Integer meta, int count) {
        super(ItemID.STONE_AXE, meta, count, "Stone Axe");
    }

    @Override
    public int getMaxDurability() {
        return ItemTool.DURABILITY_STONE;
    }

    @Override
    public boolean isAxe() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_STONE;
    }

    @Override
    public int getAttackDamage() {
        return 4;
    }
}
