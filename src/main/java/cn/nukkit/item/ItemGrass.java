package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGrass extends Item {

    public ItemGrass() {
        this(0, 1);
    }

    public ItemGrass(Integer meta) {
        this(meta, 1);
    }

    public ItemGrass(Integer meta, int count) {
        super(ItemID.GRASS, meta, count, "Grass");
        this.block = Block.get(BlockID.GRASS, meta);
    }
}