package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPotatoes extends Item {

    public ItemPotatoes() {
        this(0, 1);
    }

    public ItemPotatoes(Integer meta) {
        this(meta, 1);
    }

    public ItemPotatoes(Integer meta, int count) {
        super(ItemID.POTATOES, meta, count, "Potatoes");
        this.block = Block.get(BlockID.POTATOES, meta);
    }
}