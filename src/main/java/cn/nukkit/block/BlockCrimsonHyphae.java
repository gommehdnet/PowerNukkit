package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

@Since("1.4.0.0-PN")
@PowerNukkitOnly
public class BlockCrimsonHyphae extends BlockStem {
    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public BlockCrimsonHyphae() {
        this(0);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public BlockCrimsonHyphae(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.CRIMSON_HYPHAE;
    }
    
    @Override
    public String getName() {
        return "Crimson Hyphae";
    }

    @PowerNukkitOnly
    @Override
    protected BlockState getStrippedState() {
        return getCurrentState().withBlockId(BlockID.STRIPPED_CRIMSON_HYPHAE);
    }

    @Override
    public double getHardness() {
        return 0.3;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.CRIMSON_HYPHAE_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CRIMSON_HYPHAE);
    }
}
