package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTorch extends Item {

    public ItemTorch() {
        this(0, 1);
    }

    public ItemTorch(Integer meta) {
        this(meta, 1);
    }

    public ItemTorch(Integer meta, int count) {
        super(ItemID.TORCH, meta, count, "Torch");
        this.block = Block.get(BlockID.TORCH, meta);
    }
}