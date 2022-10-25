package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGravel extends Item {

    public ItemGravel() {
        this(0, 1);
    }

    public ItemGravel(Integer meta) {
        this(meta, 1);
    }

    public ItemGravel(Integer meta, int count) {
        super(ItemID.GRAVEL, meta, count, "Gravel");
        this.block = Block.get(BlockID.GRAVEL, meta);
    }
}