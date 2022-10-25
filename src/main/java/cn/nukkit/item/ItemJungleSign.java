package cn.nukkit.item;


import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.block.BlockJungleStandingSign;

@PowerNukkitOnly
public class ItemJungleSign extends ItemSign {
    @PowerNukkitOnly
    public ItemJungleSign() {
        this(0, 1);
    }

    @PowerNukkitOnly
    public ItemJungleSign(Integer meta) {
        this(meta, 1);
    }

    @PowerNukkitOnly
    public ItemJungleSign(Integer meta, int count) {
        super(ItemID.JUNGLE_SIGN, meta, count, "Jungle Sign");
        this.block = Block.get(BlockID.JUNGLE_STANDING_SIGN, meta);
    }
}
