package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSculk extends Item {

    public ItemSculk() {
        this(0, 1);
    }

    public ItemSculk(Integer meta) {
        this(meta, 1);
    }

    public ItemSculk(Integer meta, int count) {
        super(ItemID.SCULK, meta, count, "Sculk");
        this.block = Block.get(BlockID.SCULK, meta);
    }
}