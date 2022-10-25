package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLightBlock extends Item {

    public ItemLightBlock() {
        this(0, 1);
    }

    public ItemLightBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemLightBlock(Integer meta, int count) {
        super(ItemID.LIGHT_BLOCK, meta, count, "Light Block");
        this.block = Block.get(BlockID.LIGHT_BLOCK, meta);
    }
}