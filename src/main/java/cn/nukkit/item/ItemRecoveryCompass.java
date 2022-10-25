package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRecoveryCompass extends Item {

    public ItemRecoveryCompass() {
        this(0, 1);
    }

    public ItemRecoveryCompass(Integer meta) {
        this(meta, 1);
    }

    public ItemRecoveryCompass(Integer meta, int count) {
        super(ItemID.RECOVERY_COMPASS, meta, count, "Recovery Compass");
    }
}