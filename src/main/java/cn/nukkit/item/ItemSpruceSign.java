package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.block.BlockSpruceSignPost;

@PowerNukkitOnly
public class ItemSpruceSign extends ItemSign {
    @PowerNukkitOnly
    public ItemSpruceSign() {
        this(0, 1);
    }

    @PowerNukkitOnly
    public ItemSpruceSign(Integer meta) {
        this(meta, 1);
    }

    @PowerNukkitOnly
    public ItemSpruceSign(Integer meta, int count) {
        super(ItemID.SPRUCE_SIGN, meta, count, "Spruce Sign");
        this.block = Block.get(BlockID.SPRUCE_STANDING_SIGN, meta);
    }
}
