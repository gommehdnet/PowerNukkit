package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGrassPath extends Item {

    public ItemGrassPath() {
        this(0, 1);
    }

    public ItemGrassPath(Integer meta) {
        this(meta, 1);
    }

    public ItemGrassPath(Integer meta, int count) {
        super(ItemID.GRASS_PATH, meta, count, "Grass Path");
        this.block = Block.get(BlockID.GRASS_PATH, meta);
    }
}