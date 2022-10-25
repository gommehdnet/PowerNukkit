package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTwistingVines extends Item {

    public ItemTwistingVines() {
        this(0, 1);
    }

    public ItemTwistingVines(Integer meta) {
        this(meta, 1);
    }

    public ItemTwistingVines(Integer meta, int count) {
        super(ItemID.TWISTING_VINES, meta, count, "Twisting Vines");
        this.block = Block.get(BlockID.TWISTING_VINES, meta);
    }
}