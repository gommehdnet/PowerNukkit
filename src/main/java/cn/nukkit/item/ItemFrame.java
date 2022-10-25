package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Pub4Game
 * @since 03.07.2016
 */
public class ItemFrame extends Item {

    public ItemFrame() {
        this(0, 1);
    }

    public ItemFrame(Integer meta) {
        this(meta, 1);
    }

    public ItemFrame(Integer meta, int count) {
        super(ItemID.FRAME, meta, count, "Item Frame");
        this.block = Block.get(BlockID.FRAME);
    }
}
