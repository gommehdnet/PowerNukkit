package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemClayBall;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

/**
 * @author Nukkit Project Team
 */
public class BlockClay extends BlockSolid {

    public BlockClay() {
    }

    @Override
    public double getHardness() {
        return 0.6;
    }

    @Override
    public double getResistance() {
        return 3;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_SHOVEL;
    }

    @Override
    public BlockID getId() {
        return BlockID.CLAY;
    }

    @Override
    public String getName() {
        return "Clay Block";
    }

    @Override
    public Item[] getDrops(Item item) {
        return new Item[]{
                new ItemClayBall(4)
        };
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.CLAY_BLOCK_COLOR;
    }

    @Override
    public boolean canSilkTouch() {
        return true;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CLAY);
    }
}
