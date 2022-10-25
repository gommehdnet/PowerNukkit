package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

/**
 * @author xtypr
 * @since 2015/11/23
 */
public class BlockDarkOakFenceGate extends BlockFenceGate {
    public BlockDarkOakFenceGate() {
        this(0);
    }

    public BlockDarkOakFenceGate(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.DARK_OAK_FENCE_GATE;
    }

    @Override
    public String getName() {
        return "Dark Oak Fence Gate";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.BROWN_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DARK_OAK_FENCE_GATE);
    }
}
