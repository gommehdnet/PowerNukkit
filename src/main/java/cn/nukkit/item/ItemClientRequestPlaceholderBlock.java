package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemClientRequestPlaceholderBlock extends Item {

    public ItemClientRequestPlaceholderBlock() {
        this(0, 1);
    }

    public ItemClientRequestPlaceholderBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemClientRequestPlaceholderBlock(Integer meta, int count) {
        super(ItemID.CLIENT_REQUEST_PLACEHOLDER_BLOCK, meta, count, "Client Request Placeholder Block");
        this.block = Block.get(BlockID.CLIENT_REQUEST_PLACEHOLDER_BLOCK, meta);
    }
}