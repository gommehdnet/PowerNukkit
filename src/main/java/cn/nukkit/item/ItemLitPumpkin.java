package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLitPumpkin extends Item {

    public ItemLitPumpkin() {
        this(0, 1);
    }

    public ItemLitPumpkin(Integer meta) {
        this(meta, 1);
    }

    public ItemLitPumpkin(Integer meta, int count) {
        super(ItemID.LIT_PUMPKIN, meta, count, "Lit Pumpkin");
        this.block = Block.get(BlockID.LIT_PUMPKIN, meta);
    }
}