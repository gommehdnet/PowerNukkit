package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedDeepslateWall extends Item {

    public ItemPolishedDeepslateWall() {
        this(0, 1);
    }

    public ItemPolishedDeepslateWall(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedDeepslateWall(Integer meta, int count) {
        super(ItemID.POLISHED_DEEPSLATE_WALL, meta, count, "Polished Deepslate Wall");
        this.block = Block.get(BlockID.POLISHED_DEEPSLATE_WALL, meta);
    }
}