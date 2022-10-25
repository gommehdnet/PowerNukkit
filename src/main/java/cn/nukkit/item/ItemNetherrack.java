package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemNetherrack extends Item {

    public ItemNetherrack() {
        this(0, 1);
    }

    public ItemNetherrack(Integer meta) {
        this(meta, 1);
    }

    public ItemNetherrack(Integer meta, int count) {
        super(ItemID.NETHERRACK, meta, count, "Netherrack");
        this.block = Block.get(BlockID.NETHERRACK, meta);
    }
}