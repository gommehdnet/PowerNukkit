package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLadder extends Item {

    public ItemLadder() {
        this(0, 1);
    }

    public ItemLadder(Integer meta) {
        this(meta, 1);
    }

    public ItemLadder(Integer meta, int count) {
        super(ItemID.LADDER, meta, count, "Ladder");
        this.block = Block.get(BlockID.LADDER, meta);
    }
}