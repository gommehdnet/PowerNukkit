package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemChorusFlower extends Item {

    public ItemChorusFlower() {
        this(0, 1);
    }

    public ItemChorusFlower(Integer meta) {
        this(meta, 1);
    }

    public ItemChorusFlower(Integer meta, int count) {
        super(ItemID.CHORUS_FLOWER, meta, count, "Chorus Flower");
        this.block = Block.get(BlockID.CHORUS_FLOWER, meta);
    }
}