package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDeepslateLapisOre extends Item {

    public ItemDeepslateLapisOre() {
        this(0, 1);
    }

    public ItemDeepslateLapisOre(Integer meta) {
        this(meta, 1);
    }

    public ItemDeepslateLapisOre(Integer meta, int count) {
        super(ItemID.DEEPSLATE_LAPIS_ORE, meta, count, "Deepslate Lapis Ore");
        this.block = Block.get(BlockID.DEEPSLATE_LAPIS_ORE, meta);
    }
}