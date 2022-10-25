package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemColoredTorchBp extends Item {

    public ItemColoredTorchBp() {
        this(0, 1);
    }

    public ItemColoredTorchBp(Integer meta) {
        this(meta, 1);
    }

    public ItemColoredTorchBp(Integer meta, int count) {
        super(ItemID.COLORED_TORCH_BP, meta, count, "Colored Torch Bp");
        this.block = Block.get(BlockID.COLORED_TORCH_BP, meta);
    }
}