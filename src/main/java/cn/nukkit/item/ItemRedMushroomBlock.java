package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedMushroomBlock extends Item {

    public ItemRedMushroomBlock() {
        this(0, 1);
    }

    public ItemRedMushroomBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemRedMushroomBlock(Integer meta, int count) {
        super(ItemID.RED_MUSHROOM_BLOCK, meta, count, "Red Mushroom Block");
        this.block = Block.get(BlockID.RED_MUSHROOM_BLOCK, meta);
    }
}