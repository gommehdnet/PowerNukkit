package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemUnderwaterTorch extends Item {

    public ItemUnderwaterTorch() {
        this(0, 1);
    }

    public ItemUnderwaterTorch(Integer meta) {
        this(meta, 1);
    }

    public ItemUnderwaterTorch(Integer meta, int count) {
        super(ItemID.UNDERWATER_TORCH, meta, count, "Underwater Torch");
        this.block = Block.get(BlockID.UNDERWATER_TORCH, meta);
    }
}