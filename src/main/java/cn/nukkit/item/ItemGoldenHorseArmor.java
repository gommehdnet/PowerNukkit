package cn.nukkit.item;

public class ItemGoldenHorseArmor extends Item {
    public ItemGoldenHorseArmor() {
        this(0, 1);
    }

    public ItemGoldenHorseArmor(Integer meta) {
        this(meta, 1);
    }

    public ItemGoldenHorseArmor(Integer meta, int count) {
        super(ItemID.GOLDEN_HORSE_ARMOR, meta, count, "Golden Horse Armor");
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}
