package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLodestone extends Item {

    public ItemLodestone() {
        this(0, 1);
    }

    public ItemLodestone(Integer meta) {
        this(meta, 1);
    }

    public ItemLodestone(Integer meta, int count) {
        super(ItemID.LODESTONE, meta, count, "Lodestone");
        this.block = Block.get(BlockID.LODESTONE, meta);
    }
}