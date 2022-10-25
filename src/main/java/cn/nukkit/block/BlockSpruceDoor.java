package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemSpruceDoor;
import cn.nukkit.utils.BlockColor;

public class BlockSpruceDoor extends BlockWoodenDoor {

    public BlockSpruceDoor() {
        this(0);
    }

    public BlockSpruceDoor(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Spruce Door Block";
    }

    @Override
    public BlockID getId() {
        return BlockID.SPRUCE_DOOR;
    }

    @Override
    public Item toItem() {
        return new ItemSpruceDoor();
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.SPRUCE_BLOCK_COLOR;
    }
}
