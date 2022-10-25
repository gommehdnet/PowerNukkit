package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemColoredTorchRg extends Item {

    public ItemColoredTorchRg() {
        this(0, 1);
    }

    public ItemColoredTorchRg(Integer meta) {
        this(meta, 1);
    }

    public ItemColoredTorchRg(Integer meta, int count) {
        super(ItemID.COLORED_TORCH_RG, meta, count, "Colored Torch Rg");
        this.block = Block.get(BlockID.COLORED_TORCH_RG, meta);
    }
}