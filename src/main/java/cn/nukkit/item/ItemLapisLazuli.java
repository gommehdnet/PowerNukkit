package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLapisLazuli extends Item {

    public ItemLapisLazuli() {
        this(0, 1);
    }

    public ItemLapisLazuli(Integer meta) {
        this(meta, 1);
    }

    public ItemLapisLazuli(Integer meta, int count) {
        super(ItemID.LAPIS_LAZULI, meta, count, "Lapis Lazuli");
    }
}