package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemMelonSeeds extends Item {

    public ItemMelonSeeds() {
        this(0, 1);
    }

    public ItemMelonSeeds(Integer meta) {
        this(meta, 1);
    }

    public ItemMelonSeeds(Integer meta, int count) {
        super(ItemID.MELON_SEEDS, 0, count, "Melon Seeds");
        this.block = Block.get(BlockID.MELON_STEM);
    }
}
