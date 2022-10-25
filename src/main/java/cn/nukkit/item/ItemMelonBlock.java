package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMelonBlock extends Item {

    public ItemMelonBlock() {
        this(0, 1);
    }

    public ItemMelonBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemMelonBlock(Integer meta, int count) {
        super(ItemID.MELON_BLOCK, meta, count, "Melon Block");
        this.block = Block.get(BlockID.MELON_BLOCK, meta);
    }
}