package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStrippedAcaciaLog extends Item {

    public ItemStrippedAcaciaLog() {
        this(0, 1);
    }

    public ItemStrippedAcaciaLog(Integer meta) {
        this(meta, 1);
    }

    public ItemStrippedAcaciaLog(Integer meta, int count) {
        super(ItemID.STRIPPED_ACACIA_LOG, meta, count, "Stripped Acacia Log");
        this.block = Block.get(BlockID.STRIPPED_ACACIA_LOG, meta);
    }
}