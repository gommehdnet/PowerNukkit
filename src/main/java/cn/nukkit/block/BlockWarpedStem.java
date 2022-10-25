package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockWarpedStem extends BlockStem {

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockWarpedStem() {
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockWarpedStem(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.WARPED_STEM;
    }

    @Override
    public String getName() {
        return "Warped Stem";
    }

    @PowerNukkitOnly
    @Override
    protected BlockState getStrippedState() {
        return getCurrentState().withBlockId(BlockID.STRIPPED_WARPED_STEM);
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.WARPED_STEM_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WARPED_STEM);
    }
}
