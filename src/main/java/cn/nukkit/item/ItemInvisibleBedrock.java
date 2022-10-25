package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemInvisibleBedrock extends Item {

    public ItemInvisibleBedrock() {
        this(0, 1);
    }

    public ItemInvisibleBedrock(Integer meta) {
        this(meta, 1);
    }

    public ItemInvisibleBedrock(Integer meta, int count) {
        super(ItemID.INVISIBLE_BEDROCK, meta, count, "Invisible Bedrock");
        this.block = Block.get(BlockID.INVISIBLE_BEDROCK, meta);
    }
}