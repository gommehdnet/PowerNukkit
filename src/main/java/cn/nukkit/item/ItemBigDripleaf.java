package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBigDripleaf extends Item {

    public ItemBigDripleaf() {
        this(0, 1);
    }

    public ItemBigDripleaf(Integer meta) {
        this(meta, 1);
    }

    public ItemBigDripleaf(Integer meta, int count) {
        super(ItemID.BIG_DRIPLEAF, meta, count, "Big Dripleaf");
        this.block = Block.get(BlockID.BIG_DRIPLEAF, meta);
    }
}