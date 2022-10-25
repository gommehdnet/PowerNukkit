package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCrackedDeepslateBricks extends Item {

    public ItemCrackedDeepslateBricks() {
        this(0, 1);
    }

    public ItemCrackedDeepslateBricks(Integer meta) {
        this(meta, 1);
    }

    public ItemCrackedDeepslateBricks(Integer meta, int count) {
        super(ItemID.CRACKED_DEEPSLATE_BRICKS, meta, count, "Cracked Deepslate Bricks");
        this.block = Block.get(BlockID.CRACKED_DEEPSLATE_BRICKS, meta);
    }
}