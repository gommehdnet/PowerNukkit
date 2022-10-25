package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemJigsaw extends Item {

    public ItemJigsaw() {
        this(0, 1);
    }

    public ItemJigsaw(Integer meta) {
        this(meta, 1);
    }

    public ItemJigsaw(Integer meta, int count) {
        super(ItemID.JIGSAW, meta, count, "Jigsaw");
        this.block = Block.get(BlockID.JIGSAW, meta);
    }
}