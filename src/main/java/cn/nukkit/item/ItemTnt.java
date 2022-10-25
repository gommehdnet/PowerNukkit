package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTnt extends Item {

    public ItemTnt() {
        this(0, 1);
    }

    public ItemTnt(Integer meta) {
        this(meta, 1);
    }

    public ItemTnt(Integer meta, int count) {
        super(ItemID.TNT, meta, count, "Tnt");
        this.block = Block.get(BlockID.TNT, meta);
    }
}