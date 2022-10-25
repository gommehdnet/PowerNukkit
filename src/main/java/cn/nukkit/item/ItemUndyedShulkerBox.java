package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemUndyedShulkerBox extends Item {

    public ItemUndyedShulkerBox() {
        this(0, 1);
    }

    public ItemUndyedShulkerBox(Integer meta) {
        this(meta, 1);
    }

    public ItemUndyedShulkerBox(Integer meta, int count) {
        super(ItemID.UNDYED_SHULKER_BOX, meta, count, "Undyed Shulker Box");
        this.block = Block.get(BlockID.UNDYED_SHULKER_BOX, meta);
    }
}