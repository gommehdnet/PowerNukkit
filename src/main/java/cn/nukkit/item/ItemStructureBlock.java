package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStructureBlock extends Item {

    public ItemStructureBlock() {
        this(0, 1);
    }

    public ItemStructureBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemStructureBlock(Integer meta, int count) {
        super(ItemID.STRUCTURE_BLOCK, meta, count, "Structure Block");
        this.block = Block.get(BlockID.STRUCTURE_BLOCK, meta);
    }
}