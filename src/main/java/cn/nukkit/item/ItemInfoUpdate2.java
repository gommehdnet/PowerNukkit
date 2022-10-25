package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemInfoUpdate2 extends Item {

    public ItemInfoUpdate2() {
        this(0, 1);
    }

    public ItemInfoUpdate2(Integer meta) {
        this(meta, 1);
    }

    public ItemInfoUpdate2(Integer meta, int count) {
        super(ItemID.INFO_UPDATE2, meta, count, "Info Update2");
        this.block = Block.get(BlockID.INFO_UPDATE2, meta);
    }
}