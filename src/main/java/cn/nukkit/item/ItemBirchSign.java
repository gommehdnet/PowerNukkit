package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

@PowerNukkitOnly
public class ItemBirchSign extends ItemSign {
    @PowerNukkitOnly
    public ItemBirchSign() {
        this(0, 1);
    }

    @PowerNukkitOnly
    public ItemBirchSign(Integer meta) {
        this(meta, 1);
    }

    @PowerNukkitOnly
    public ItemBirchSign(Integer meta, int count) {
        super(ItemID.BIRCH_SIGN, meta, count, "Birch Sign");
        this.block = Block.get(BlockID.BIRCH_STANDING_SIGN, meta);
    }
}
