package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWritableBook extends ItemBookWritable {

    public ItemWritableBook() {
        this(0, 1);
    }

    public ItemWritableBook(Integer meta) {
        this(meta, 1);
    }

    public ItemWritableBook(Integer meta, int count) {
        super(ItemID.WRITABLE_BOOK, 0, count, "Writable Book");
    }
}