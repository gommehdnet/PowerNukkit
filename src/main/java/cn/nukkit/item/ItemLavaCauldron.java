package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLavaCauldron extends Item {

    public ItemLavaCauldron() {
        this(0, 1);
    }

    public ItemLavaCauldron(Integer meta) {
        this(meta, 1);
    }

    public ItemLavaCauldron(Integer meta, int count) {
        super(ItemID.LAVA_CAULDRON, meta, count, "Lava Cauldron");
        this.block = Block.get(BlockID.LAVA_CAULDRON, meta);
    }
}