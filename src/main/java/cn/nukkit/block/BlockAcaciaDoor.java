package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemAcaciaDoor;
import cn.nukkit.utils.BlockColor;

public class BlockAcaciaDoor extends BlockWoodenDoor {

    public BlockAcaciaDoor() {
        this(0);
    }

    public BlockAcaciaDoor(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Acacia Door Block";
    }

    @Override
    public BlockID getId() {
        return BlockID.ACACIA_DOOR;
    }

    @Override
    public Item toItem() {
        return new ItemAcaciaDoor();
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.ORANGE_BLOCK_COLOR;
    }
}
