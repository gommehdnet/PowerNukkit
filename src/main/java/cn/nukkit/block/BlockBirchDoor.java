package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBirchDoor;
import cn.nukkit.utils.BlockColor;

public class BlockBirchDoor extends BlockWoodenDoor {

    public BlockBirchDoor() {
        this(0);
    }

    public BlockBirchDoor(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Birch Door Block";
    }

    @Override
    public BlockID getId() {
        return BlockID.BIRCH_DOOR;
    }

    @Override
    public Item toItem() {
        return new ItemBirchDoor();
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.SAND_BLOCK_COLOR;
    }
}
