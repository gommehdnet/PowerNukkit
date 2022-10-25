package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

@SuppressWarnings("deprecation")
public class BlockRedNetherBrick extends BlockNetherBrick {

    public BlockRedNetherBrick() {
        // Does nothing
    }

    @Override
    public String getName() {
        return "Red Nether Bricks";
    }

    @Override
    public BlockID getId() {
        return BlockID.RED_NETHER_BRICK;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    @PowerNukkitOnly
    public int getToolTier() {
        return ItemTool.TIER_WOODEN;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.NETHERRACK_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.RED_NETHER_BRICK);
    }
}
