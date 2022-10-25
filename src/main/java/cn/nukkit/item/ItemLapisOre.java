package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLapisOre extends Item {

    public ItemLapisOre() {
        this(0, 1);
    }

    public ItemLapisOre(Integer meta) {
        this(meta, 1);
    }

    public ItemLapisOre(Integer meta, int count) {
        super(ItemID.LAPIS_ORE, meta, count, "Lapis Ore");
        this.block = Block.get(BlockID.LAPIS_ORE, meta);
    }
}