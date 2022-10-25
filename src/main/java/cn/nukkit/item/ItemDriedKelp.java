package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author PetteriM1
 */
public class ItemDriedKelp extends ItemEdible {

    public ItemDriedKelp() {
        this(0, 1);
    }

    public ItemDriedKelp(Integer meta) {
        this(meta, 1);
    }

    public ItemDriedKelp(Integer meta, int count) {
        super(ItemID.DRIED_KELP, 0, count, "Dried Kelp");
        this.block = Block.get(BlockID.DRIED_KELP_BLOCK);
    }
}
