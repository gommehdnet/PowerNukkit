package cn.nukkit.item;

public class ItemDiamondHorseArmor extends Item {
    public ItemDiamondHorseArmor() {
        this(0, 1);
    }

    public ItemDiamondHorseArmor(Integer meta) {
        this(meta, 1);
    }

    public ItemDiamondHorseArmor(Integer meta, int count) {
        super(ItemID.DIAMOND_HORSE_ARMOR, meta, count, "Diamond Horse Armor");
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}
