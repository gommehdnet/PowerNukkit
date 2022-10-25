package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPumpkinStem extends Item {

    public ItemPumpkinStem() {
        this(0, 1);
    }

    public ItemPumpkinStem(Integer meta) {
        this(meta, 1);
    }

    public ItemPumpkinStem(Integer meta, int count) {
        super(ItemID.PUMPKIN_STEM, meta, count, "Pumpkin Stem");
        this.block = Block.get(BlockID.PUMPKIN_STEM, meta);
    }
}