package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEnchantedBook extends Item {

    public ItemEnchantedBook() {
        this(0, 1);
    }

    public ItemEnchantedBook(Integer meta) {
        this(meta, 1);
    }

    public ItemEnchantedBook(Integer meta, int count) {
        super(ItemID.ENCHANTED_BOOK, meta, count, "Enchanted Book");
    }
}