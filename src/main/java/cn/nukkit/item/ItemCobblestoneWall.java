package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCobblestoneWall extends Item {

    public ItemCobblestoneWall() {
        this(0, 1);
    }

    public ItemCobblestoneWall(Integer meta) {
        this(meta, 1);
    }

    public ItemCobblestoneWall(Integer meta, int count) {
        super(ItemID.COBBLESTONE_WALL, meta, count, "Cobblestone Wall");
        this.block = Block.get(BlockID.COBBLESTONE_WALL, meta);
    }
}