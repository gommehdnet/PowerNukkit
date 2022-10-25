package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

/**
 * @author xtypr
 * @since 2015/11/23
 */
public class BlockJungleFenceGate extends BlockFenceGate {
    public BlockJungleFenceGate() {
        this(0);
    }

    public BlockJungleFenceGate(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.JUNGLE_FENCE_GATE;
    }

    @Override
    public String getName() {
        return "Jungle Fence Gate";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.DIRT_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.JUNGLE_FENCE_GATE);
    }
}
