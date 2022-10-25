package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBedrock extends Item {

    public ItemBedrock() {
        this(0, 1);
    }

    public ItemBedrock(Integer meta) {
        this(meta, 1);
    }

    public ItemBedrock(Integer meta, int count) {
        super(ItemID.BEDROCK, meta, count, "Bedrock");
        this.block = Block.get(BlockID.BEDROCK, meta);
    }
}