package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRedstoneOre extends Item {

    public ItemRedstoneOre() {
        this(0, 1);
    }

    public ItemRedstoneOre(Integer meta) {
        this(meta, 1);
    }

    public ItemRedstoneOre(Integer meta, int count) {
        super(ItemID.REDSTONE_ORE, meta, count, "Redstone Ore");
        this.block = Block.get(BlockID.REDSTONE_ORE, meta);
    }
}