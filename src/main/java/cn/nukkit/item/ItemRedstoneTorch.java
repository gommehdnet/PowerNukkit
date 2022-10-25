package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedstoneTorch extends Item {

    public ItemRedstoneTorch() {
        this(0, 1);
    }

    public ItemRedstoneTorch(Integer meta) {
        this(meta, 1);
    }

    public ItemRedstoneTorch(Integer meta, int count) {
        super(ItemID.REDSTONE_TORCH, meta, count, "Redstone Torch");
        this.block = Block.get(BlockID.REDSTONE_TORCH, meta);
    }
}