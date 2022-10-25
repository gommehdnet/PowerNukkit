package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWeb extends Item {

    public ItemWeb() {
        this(0, 1);
    }

    public ItemWeb(Integer meta) {
        this(meta, 1);
    }

    public ItemWeb(Integer meta, int count) {
        super(ItemID.WEB, meta, count, "Web");
        this.block = Block.get(BlockID.WEB, meta);
    }
}