package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMycelium extends Item {

    public ItemMycelium() {
        this(0, 1);
    }

    public ItemMycelium(Integer meta) {
        this(meta, 1);
    }

    public ItemMycelium(Integer meta, int count) {
        super(ItemID.MYCELIUM, meta, count, "Mycelium");
        this.block = Block.get(BlockID.MYCELIUM, meta);
    }
}