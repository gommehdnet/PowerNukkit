package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEndStone extends Item {

    public ItemEndStone() {
        this(0, 1);
    }

    public ItemEndStone(Integer meta) {
        this(meta, 1);
    }

    public ItemEndStone(Integer meta, int count) {
        super(ItemID.END_STONE, meta, count, "End Stone");
        this.block = Block.get(BlockID.END_STONE, meta);
    }
}