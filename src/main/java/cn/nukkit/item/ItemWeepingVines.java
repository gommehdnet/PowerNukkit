package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWeepingVines extends Item {

    public ItemWeepingVines() {
        this(0, 1);
    }

    public ItemWeepingVines(Integer meta) {
        this(meta, 1);
    }

    public ItemWeepingVines(Integer meta, int count) {
        super(ItemID.WEEPING_VINES, meta, count, "Weeping Vines");
        this.block = Block.get(BlockID.WEEPING_VINES, meta);
    }
}