package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemYellowFlower extends Item {

    public ItemYellowFlower() {
        this(0, 1);
    }

    public ItemYellowFlower(Integer meta) {
        this(meta, 1);
    }

    public ItemYellowFlower(Integer meta, int count) {
        super(ItemID.YELLOW_FLOWER, meta, count, "Yellow Flower");
        this.block = Block.get(BlockID.YELLOW_FLOWER, meta);
    }
}