package cn.nukkit.item;

/**
 * @author Leonidius20
 * @since 18.08.18
 */
public class ItemFermentedSpiderEye extends Item {

    public ItemFermentedSpiderEye() {
        this(0);
    }

    public ItemFermentedSpiderEye(Integer meta) {
        this(0, 1);
    }

    public ItemFermentedSpiderEye(Integer meta, int count) {
        super(ItemID.FERMENTED_SPIDER_EYE, meta, count, "Fermented Spider Eye");
    }
}
