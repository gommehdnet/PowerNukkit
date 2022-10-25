package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemConcrete extends Item {

    public ItemConcrete() {
        this(0, 1);
    }

    public ItemConcrete(Integer meta) {
        this(meta, 1);
    }

    public ItemConcrete(Integer meta, int count) {
        super(ItemID.CONCRETE, meta, count, "Concrete");
        this.block = Block.get(BlockID.CONCRETE, meta);
    }
}