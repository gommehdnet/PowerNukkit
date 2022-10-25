package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBrownMushroomBlock extends Item {

    public ItemBrownMushroomBlock() {
        this(0, 1);
    }

    public ItemBrownMushroomBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemBrownMushroomBlock(Integer meta, int count) {
        super(ItemID.BROWN_MUSHROOM_BLOCK, meta, count, "Brown Mushroom Block");
        this.block = Block.get(BlockID.BROWN_MUSHROOM_BLOCK, meta);
    }
}