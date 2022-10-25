package cn.nukkit.item;


import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockAcaciaStandingSign;
import cn.nukkit.block.BlockID;

@PowerNukkitOnly
public class ItemAcaciaSign extends ItemSign {
    @PowerNukkitOnly
    public ItemAcaciaSign() {
        this(0, 1);
    }

    @PowerNukkitOnly
    public ItemAcaciaSign(Integer meta) {
        this(meta, 1);
    }

    @PowerNukkitOnly
    public ItemAcaciaSign(Integer meta, int count) {
        super(ItemID.ACACIA_SIGN, meta, count, "Acacia Sign");
        this.block = Block.get(BlockID.ACACIA_STANDING_SIGN, meta);
    }
}
