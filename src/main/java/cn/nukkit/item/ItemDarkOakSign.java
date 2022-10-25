package cn.nukkit.item;


import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

@PowerNukkitOnly
public class ItemDarkOakSign extends ItemSign {
    @PowerNukkitOnly
    public ItemDarkOakSign() {
        this(0, 1);
    }

    @PowerNukkitOnly
    public ItemDarkOakSign(Integer meta) {
        this(meta, 1);
    }

    @PowerNukkitOnly
    public ItemDarkOakSign(Integer meta, int count) {
        super(ItemID.DARK_OAK_SIGN, meta, count, "Dark Oak Sign");
        this.block = Block.get(BlockID.DARKOAK_STANDING_SIGN, meta);
    }
}
