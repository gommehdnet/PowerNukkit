package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemBeetrootSeeds extends Item {

    public ItemBeetrootSeeds() {
        this(0, 1);
    }

    public ItemBeetrootSeeds(Integer meta) {
        this(meta, 1);
    }

    public ItemBeetrootSeeds(Integer meta, int count) {
        super(ItemID.BEETROOT_SEEDS, 0, count, "Beetroot Seeds");
        this.block = Block.get(BlockID.BEETROOT, meta);
    }
}
