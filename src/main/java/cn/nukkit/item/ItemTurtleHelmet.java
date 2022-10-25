package cn.nukkit.item;

/**
 * @author PetteriM1
 */
public class ItemTurtleHelmet extends ItemArmor {

    public ItemTurtleHelmet() {
        this(0, 1);
    }

    public ItemTurtleHelmet(Integer meta) {
        this(meta, 1);
    }

    public ItemTurtleHelmet(Integer meta, int count) {
        super(ItemID.TURTLE_HELMET, meta, count, "Turtle Shell");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_OTHER;
    }

    @Override
    public boolean isHelmet() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 2;
    }

    @Override
    public int getMaxDurability() {
        return 276;
    }

    @Override
    public int getToughness() {
        return 2;
    }
}
