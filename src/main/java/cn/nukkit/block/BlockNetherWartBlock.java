package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

@Since("1.4.0.0-PN")
public class BlockNetherWartBlock extends BlockSolid {

    @Since("1.4.0.0-PN")
    public BlockNetherWartBlock() {
        // Does nothing
    }

    @Override
    public String getName() {
        return "Nether Wart Block";
    }

    @Override
    public BlockID getId() {
        return BlockID.NETHER_WART_BLOCK;
    }

    @Override
    public double getResistance() {
        return 5;
    }

    @Override
    public double getHardness() {
        return 1;
    }

    @PowerNukkitDifference(info = "It's now hoe instead of none", since = "1.4.0.0-PN")
    @Override
    public int getToolType() {
        return ItemTool.TYPE_HOE;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.RED_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.NETHER_WART);
    }
}
