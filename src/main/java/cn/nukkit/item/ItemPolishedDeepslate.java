package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedDeepslate extends Item {

    public ItemPolishedDeepslate() {
        this(0, 1);
    }

    public ItemPolishedDeepslate(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedDeepslate(Integer meta, int count) {
        super(ItemID.POLISHED_DEEPSLATE, meta, count, "Polished Deepslate");
        this.block = Block.get(BlockID.POLISHED_DEEPSLATE, meta);
    }
}