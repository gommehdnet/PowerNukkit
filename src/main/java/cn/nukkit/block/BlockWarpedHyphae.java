package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

@Since("1.4.0.0-PN")
@PowerNukkitOnly
public class BlockWarpedHyphae extends BlockStem {

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public BlockWarpedHyphae() {
        this(0);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public BlockWarpedHyphae(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.WARPED_HYPHAE;
    }

    @Override
    public String getName() {
        return "Warped Hyphae";
    }

    @PowerNukkitOnly
    @Override
    protected BlockState getStrippedState() {
        return getCurrentState().withBlockId(BlockID.STRIPPED_WARPED_HYPHAE);
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.WARPED_HYPHAE_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WARPED_HYPHAE);
    }
}
