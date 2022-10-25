package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateBricks extends Item {

    public ItemDeepslateBricks() {
        this(0, 1);
    }

    public ItemDeepslateBricks(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateBricks(Integer meta, int count) {
        super(ItemID.DEEPSLATE_BRICKS, meta, count, "Deepslate Bricks");
        this.block = Block.get(BlockID.DEEPSLATE_BRICKS, meta);
    }
}