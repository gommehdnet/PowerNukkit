package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSoulTorch extends Item {

    public ItemSoulTorch() {
        this(0, 1);
    }

    public ItemSoulTorch(Integer meta) {
        this(meta, 1);
    }

    public ItemSoulTorch(Integer meta, int count) {
        super(ItemID.SOUL_TORCH, meta, count, "Soul Torch");
        this.block = Block.get(BlockID.SOUL_TORCH, meta);
    }
}