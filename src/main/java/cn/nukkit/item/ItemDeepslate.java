package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslate extends Item {

    public ItemDeepslate() {
        this(0, 1);
    }

    public ItemDeepslate(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslate(Integer meta, int count) {
        super(ItemID.DEEPSLATE, meta, count, "Deepslate");
        this.block = Block.get(BlockID.DEEPSLATE, meta);
    }
}