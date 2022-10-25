package cn.nukkit.item;

public class ItemShulkerShell extends Item {

    public ItemShulkerShell() {
        this(0, 1);
    }

    public ItemShulkerShell(Integer meta) {
        this(meta, 1);
    }

    public ItemShulkerShell(Integer meta, int count) {
        super(ItemID.SHULKER_SHELL, meta, count, "Shulker Shell");
    }

}
