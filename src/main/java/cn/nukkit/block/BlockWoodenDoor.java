package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemWoodenDoor;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class BlockWoodenDoor extends BlockDoor {

    public BlockWoodenDoor() {
        this(0);
    }

    public BlockWoodenDoor(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Wood Door Block";
    }

    @Override
    public BlockID getId() {
        return BlockID.WOODEN_DOOR;
    }

    @Override
    public double getHardness() {
        return 3;
    }

    @Override
    public double getResistance() {
        return 15;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_AXE;
    }

    @Override
    public Item toItem() {
        return new ItemWoodenDoor();
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.WOOD_BLOCK_COLOR;
    }
}
