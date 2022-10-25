package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCaveVines extends Item {

    public ItemCaveVines() {
        this(0, 1);
    }

    public ItemCaveVines(Integer meta) {
        this(meta, 1);
    }

    public ItemCaveVines(Integer meta, int count) {
        super(ItemID.CAVE_VINES, meta, count, "Cave Vines");
        this.block = Block.get(BlockID.CAVE_VINES, meta);
    }
}