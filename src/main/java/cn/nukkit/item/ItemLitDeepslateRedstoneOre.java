package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLitDeepslateRedstoneOre extends Item {

    public ItemLitDeepslateRedstoneOre() {
        this(0, 1);
    }

    public ItemLitDeepslateRedstoneOre(Integer meta) {
        this(meta, 1);
    }

    public ItemLitDeepslateRedstoneOre(Integer meta, int count) {
        super(ItemID.LIT_DEEPSLATE_REDSTONE_ORE, meta, count, "Lit Deepslate Redstone Ore");
        this.block = Block.get(BlockID.LIT_DEEPSLATE_REDSTONE_ORE, meta);
    }
}