package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockWarpedRoots extends BlockRoots {

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockWarpedRoots() {
        // Does nothing
    }

    @Override
    public BlockID getId() {
        return BlockID.WARPED_ROOTS;
    }

    @Override
    public String getName() {
        return "Warped Roots";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.CYAN_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WARPED_ROOTS);
    }
}
