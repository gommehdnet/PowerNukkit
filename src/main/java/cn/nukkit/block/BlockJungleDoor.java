package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemJungleDoor;
import cn.nukkit.utils.BlockColor;

public class BlockJungleDoor extends BlockWoodenDoor {

    public BlockJungleDoor() {
        this(0);
    }

    public BlockJungleDoor(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Jungle Door Block";
    }

    @Override
    public BlockID getId() {
        return BlockID.JUNGLE_DOOR;
    }

    @Override
    public Item toItem() {
        return new ItemJungleDoor();
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.DIRT_BLOCK_COLOR;
    }
}
