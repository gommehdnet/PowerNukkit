package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemChiseledDeepslate extends Item {

    public ItemChiseledDeepslate() {
        this(0, 1);
    }

    public ItemChiseledDeepslate(Integer meta) {
        this(meta, 1);
    }

    public ItemChiseledDeepslate(Integer meta, int count) {
        super(ItemID.CHISELED_DEEPSLATE, meta, count, "Chiseled Deepslate");
        this.block = Block.get(BlockID.CHISELED_DEEPSLATE, meta);
    }
}