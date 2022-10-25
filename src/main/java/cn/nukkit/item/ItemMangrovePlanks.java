package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMangrovePlanks extends Item {

    public ItemMangrovePlanks() {
        this(0, 1);
    }

    public ItemMangrovePlanks(Integer meta) {
        this(meta, 1);
    }

    public ItemMangrovePlanks(Integer meta, int count) {
        super(ItemID.MANGROVE_PLANKS, meta, count, "Mangrove Planks");
        this.block = Block.get(BlockID.MANGROVE_PLANKS, meta);
    }
}