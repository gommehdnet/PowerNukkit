package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEnchantedGoldenApple extends Item {

    public ItemEnchantedGoldenApple() {
        this(0, 1);
    }

    public ItemEnchantedGoldenApple(Integer meta) {
        this(meta, 1);
    }

    public ItemEnchantedGoldenApple(Integer meta, int count) {
        super(ItemID.ENCHANTED_GOLDEN_APPLE, meta, count, "Enchanted Golden Apple");
    }
}