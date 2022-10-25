package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockCrimsonStem extends BlockStem {

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockCrimsonStem() {
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockCrimsonStem(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.CRIMSON_STEM;
    }

    @Override
    public String getName() {
        return "Crimson Stem";
    }

    @PowerNukkitOnly
    @Override
    protected BlockState getStrippedState() {
        return getCurrentState().withBlockId(BlockID.STRIPPED_CRIMSON_STEM);
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.CRIMSON_STEM_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CRIMSON_STEM);
    }

}
