package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemIronAxe extends ItemTool {

    public ItemIronAxe() {
        this(0, 1);
    }

    public ItemIronAxe(Integer meta) {
        this(meta, 1);
    }

    public ItemIronAxe(Integer meta, int count) {
        super(ItemID.IRON_AXE, meta, count, "Iron Axe");
    }

    @Override
    public int getMaxDurability() {
        return ItemTool.DURABILITY_IRON;
    }

    @Override
    public boolean isAxe() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_IRON;
    }

    @Override
    public int getAttackDamage() {
        return 5;
    }
}
