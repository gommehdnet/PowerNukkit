package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMangroveFenceGate extends BlockFenceGate {

    @Override
    public BlockID getId() {
        return BlockID.MANGROVE_FENCE_GATE;
    }

    @Override
    public String getName() {
        return "Mangrove Fence Gate";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MANGROVE_FENCE_GATE);
    }
}