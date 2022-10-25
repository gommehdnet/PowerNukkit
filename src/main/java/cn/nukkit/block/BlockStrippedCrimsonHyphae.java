package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

@Since("1.4.0.0-PN")
@PowerNukkitOnly
public class BlockStrippedCrimsonHyphae extends BlockStemStripped {

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public BlockStrippedCrimsonHyphae() {
        this(0);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public BlockStrippedCrimsonHyphae(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.STRIPPED_CRIMSON_HYPHAE;
    }
    
    @Override
    public String getName() {
        return "Crimson Stripped Hyphae";
    }

    @Override
    public double getHardness() {
        return 0.4;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.CRIMSON_HYPHAE_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.STRIPPED_CRIMSON_HYPHAE);
    }
}
