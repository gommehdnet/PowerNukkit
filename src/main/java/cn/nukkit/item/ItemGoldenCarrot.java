package cn.nukkit.item;

public class ItemGoldenCarrot extends ItemEdible {
    public ItemGoldenCarrot() {
        this(0, 1);
    }

    public ItemGoldenCarrot(Integer meta) {
        this(meta, 1);
    }

    public ItemGoldenCarrot(Integer meta, int count) {
        super(ItemID.GOLDEN_CARROT, 0, count, "Golden Carrot");
    }
}
