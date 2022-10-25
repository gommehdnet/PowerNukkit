package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemDarkOakDoor;
import cn.nukkit.utils.BlockColor;

public class BlockDarkOakDoor extends BlockWoodenDoor {

    public BlockDarkOakDoor() {
        this(0);
    }

    public BlockDarkOakDoor(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Dark Oak Door Block";
    }

    @Override
    public BlockID getId() {
        return BlockID.DARK_OAK_DOOR;
    }

    @Override
    public Item toItem() {
        return new ItemDarkOakDoor();
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.BROWN_BLOCK_COLOR;
    }
}
