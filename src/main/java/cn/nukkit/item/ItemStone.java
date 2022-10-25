package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStone extends Item {

    public ItemStone() {
        this(0, 1);
    }

    public ItemStone(Integer meta) {
        this(meta, 1);
    }

    public ItemStone(Integer meta, int count) {
        super(ItemID.STONE, meta, count, "Stone");
        this.block = Block.get(BlockID.STONE, meta);
    }
}