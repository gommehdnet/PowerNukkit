package cn.nukkit.item;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemMelonSlice extends ItemEdible {

    public ItemMelonSlice() {
        this(0, 1);
    }

    public ItemMelonSlice(Integer meta) {
        this(meta, 1);
    }

    public ItemMelonSlice(Integer meta, int count) {
        super(ItemID.MELON_SLICE, meta, count, "Melon Slice");
    }
}
