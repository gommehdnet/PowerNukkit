package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLitRedstoneOre extends Item {

    public ItemLitRedstoneOre() {
        this(0, 1);
    }

    public ItemLitRedstoneOre(Integer meta) {
        this(meta, 1);
    }

    public ItemLitRedstoneOre(Integer meta, int count) {
        super(ItemID.LIT_REDSTONE_ORE, meta, count, "Lit Redstone Ore");
        this.block = Block.get(BlockID.LIT_REDSTONE_ORE, meta);
    }
}