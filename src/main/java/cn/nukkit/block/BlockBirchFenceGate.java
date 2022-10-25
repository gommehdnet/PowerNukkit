package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

/**
 * @author xtypr
 * @since 2015/11/23
 */
public class BlockBirchFenceGate extends BlockFenceGate {
    public BlockBirchFenceGate() {
        this(0);
    }

    public BlockBirchFenceGate(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.BIRCH_FENCE_GATE;
    }

    @Override
    public String getName() {
        return "Birch Fence Gate";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.SAND_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BIRCH_FENCE_GATE);
    }
}
