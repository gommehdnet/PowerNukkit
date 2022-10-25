package cn.nukkit.item;

public class ItemCookedMutton extends ItemEdible {

    public ItemCookedMutton() {
        this(0, 1);
    }

    public ItemCookedMutton(Integer meta) {
        this(meta, 1);
    }

    public ItemCookedMutton(Integer meta, int count) {
        super(ItemID.COOKED_MUTTON, meta, count, "Cooked Mutton");
    }
}
