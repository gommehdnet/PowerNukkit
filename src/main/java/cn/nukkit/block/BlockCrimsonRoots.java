package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockCrimsonRoots extends BlockRoots {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockCrimsonRoots() {
        // Does nothing
    }

    @Override
    public BlockID getId() {
        return BlockID.CRIMSON_ROOTS;
    }

    @Override
    public String getName() {
        return "Crimson Roots";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.NETHERRACK_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CRIMSON_ROOTS);
    }
}
