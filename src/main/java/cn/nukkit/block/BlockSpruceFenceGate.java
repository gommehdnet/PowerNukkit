package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

/**
 * @author xtypr
 * @since 2015/11/23
 */
public class BlockSpruceFenceGate extends BlockFenceGate {
    public BlockSpruceFenceGate() {
        this(0);
    }

    public BlockSpruceFenceGate(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.SPRUCE_FENCE_GATE;
    }

    @Override
    public String getName() {
        return "Spruce Fence Gate";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.SPRUCE_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SPRUCE_FENCE_GATE);
    }
}
