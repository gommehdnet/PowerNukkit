package cn.nukkit.item;

public class ItemIronHorseArmor extends Item {
    public ItemIronHorseArmor() {
        this(0, 1);
    }

    public ItemIronHorseArmor(Integer meta) {
        this(meta, 1);
    }

    public ItemIronHorseArmor(Integer meta, int count) {
        super(ItemID.IRON_HORSE_ARMOR, meta, count, "Iron Horse Armor");
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}
