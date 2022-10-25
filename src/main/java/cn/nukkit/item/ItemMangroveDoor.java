package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangroveDoor extends Item {

    public ItemMangroveDoor() {
        this(0, 1);
    }

    public ItemMangroveDoor(Integer meta) {
        this(meta, 1);
    }

    public ItemMangroveDoor(Integer meta, int count) {
        super(ItemID.MANGROVE_DOOR, meta, count, "Mangrove Door");
        this.block = Block.get(BlockID.MANGROVE_DOOR, meta);
    }
}