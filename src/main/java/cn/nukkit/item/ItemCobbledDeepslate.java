package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCobbledDeepslate extends Item {

    public ItemCobbledDeepslate() {
        this(0, 1);
    }

    public ItemCobbledDeepslate(Integer meta) {
        this(meta, 1);
    }

    public ItemCobbledDeepslate(Integer meta, int count) {
        super(ItemID.COBBLED_DEEPSLATE, meta, count, "Cobbled Deepslate");
        this.block = Block.get(BlockID.COBBLED_DEEPSLATE, meta);
    }
}