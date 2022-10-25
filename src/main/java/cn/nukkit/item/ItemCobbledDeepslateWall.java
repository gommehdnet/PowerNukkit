package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCobbledDeepslateWall extends Item {

    public ItemCobbledDeepslateWall() {
        this(0, 1);
    }

    public ItemCobbledDeepslateWall(Integer meta) {
        this(meta, 1);
    }

    public ItemCobbledDeepslateWall(Integer meta, int count) {
        super(ItemID.COBBLED_DEEPSLATE_WALL, meta, count, "Cobbled Deepslate Wall");
        this.block = Block.get(BlockID.COBBLED_DEEPSLATE_WALL, meta);
    }
}