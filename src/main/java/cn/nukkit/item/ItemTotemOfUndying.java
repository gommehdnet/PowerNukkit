package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;

public class ItemTotemOfUndying extends Item {

    @PowerNukkitOnly
    public ItemTotemOfUndying() {
        this(0, 1);
    }

    public ItemTotemOfUndying(Integer meta) {
        this(meta, 1);
    }

    public ItemTotemOfUndying(Integer meta, int count) {
        super(ItemID.TOTEM_OF_UNDYING, meta, count, "Totem of Undying");
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}
