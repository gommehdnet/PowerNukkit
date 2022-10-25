package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTripwireHook extends Item {

    public ItemTripwireHook() {
        this(0, 1);
    }

    public ItemTripwireHook(Integer meta) {
        this(meta, 1);
    }

    public ItemTripwireHook(Integer meta, int count) {
        super(ItemID.TRIPWIRE_HOOK, meta, count, "Tripwire Hook");
        this.block = Block.get(BlockID.TRIPWIRE_HOOK, meta);
    }
}