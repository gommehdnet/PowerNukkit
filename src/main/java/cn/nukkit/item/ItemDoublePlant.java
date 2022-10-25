package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDoublePlant extends Item {

    public ItemDoublePlant() {
        this(0, 1);
    }

    public ItemDoublePlant(Integer meta) {
        this(meta, 1);
    }

    public ItemDoublePlant(Integer meta, int count) {
        super(ItemID.DOUBLE_PLANT, meta, count, "Double Plant");
        this.block = Block.get(BlockID.DOUBLE_PLANT, meta);
    }
}