package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.BlockSoulCampfire;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class ItemSoulCampfire extends Item {

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public ItemSoulCampfire() {
        this(0, 1);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public ItemSoulCampfire(Integer meta) {
        this(meta, 1);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public ItemSoulCampfire(Integer meta, int count) {
        super(ItemID.SOUL_CAMPFIRE, meta, count, "Soul Campfire");
        this.block = new BlockSoulCampfire();
    }

    @Override
    public int getMaxStackSize() {
        return 1;
    }
}
