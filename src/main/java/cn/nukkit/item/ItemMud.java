package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMud extends Item {

    public ItemMud() {
        this(0, 1);
    }

    public ItemMud(Integer meta) {
        this(meta, 1);
    }

    public ItemMud(Integer meta, int count) {
        super(ItemID.MUD, meta, count, "Mud");
        this.block = Block.get(BlockID.MUD, meta);
    }
}