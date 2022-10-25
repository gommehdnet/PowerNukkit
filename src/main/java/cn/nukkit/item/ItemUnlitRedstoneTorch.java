package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemUnlitRedstoneTorch extends Item {

    public ItemUnlitRedstoneTorch() {
        this(0, 1);
    }

    public ItemUnlitRedstoneTorch(Integer meta) {
        this(meta, 1);
    }

    public ItemUnlitRedstoneTorch(Integer meta, int count) {
        super(ItemID.UNLIT_REDSTONE_TORCH, meta, count, "Unlit Redstone Torch");
        this.block = Block.get(BlockID.UNLIT_REDSTONE_TORCH, meta);
    }
}