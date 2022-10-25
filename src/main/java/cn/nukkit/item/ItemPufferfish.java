package cn.nukkit.item;

/**
 * @author Snake1999
 * @since 2016/1/14
 */
public class ItemPufferfish extends ItemCod {

    public ItemPufferfish() {
        this(0, 1);
    }

    public ItemPufferfish(Integer meta) {
        this(meta, 1);
    }

    public ItemPufferfish(Integer meta, int count) {
        super(ItemID.PUFFERFISH, meta, count, "Pufferfish");
    }

}
