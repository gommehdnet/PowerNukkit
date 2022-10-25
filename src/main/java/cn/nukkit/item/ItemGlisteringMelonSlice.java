package cn.nukkit.item;

/**
 * @author Leonidius20
 * @since 18.08.18
 */
public class ItemGlisteringMelonSlice extends Item {

    public ItemGlisteringMelonSlice() {
        this(0);
    }

    public ItemGlisteringMelonSlice(Integer meta) {
        this(meta, 1);
    }

    public ItemGlisteringMelonSlice(Integer meta, int count) {
        super(ItemID.GLISTERING_MELON_SLICE, meta, count, "Glistering Melon Slice");
    }
}
