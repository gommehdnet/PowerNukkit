package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSpruceTrapdoor extends Item {

    public ItemSpruceTrapdoor() {
        this(0, 1);
    }

    public ItemSpruceTrapdoor(Integer meta) {
        this(meta, 1);
    }

    public ItemSpruceTrapdoor(Integer meta, int count) {
        super(ItemID.SPRUCE_TRAPDOOR, meta, count, "Spruce Trapdoor");
        this.block = Block.get(BlockID.SPRUCE_TRAPDOOR, meta);
    }
}