package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedFlower extends Item {

    public ItemRedFlower() {
        this(0, 1);
    }

    public ItemRedFlower(Integer meta) {
        this(meta, 1);
    }

    public ItemRedFlower(Integer meta, int count) {
        super(ItemID.RED_FLOWER, meta, count, "Red Flower");
        this.block = Block.get(BlockID.RED_FLOWER, meta);
    }
}