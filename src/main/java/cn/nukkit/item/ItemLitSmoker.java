package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLitSmoker extends Item {

    public ItemLitSmoker() {
        this(0, 1);
    }

    public ItemLitSmoker(Integer meta) {
        this(meta, 1);
    }

    public ItemLitSmoker(Integer meta, int count) {
        super(ItemID.LIT_SMOKER, meta, count, "Lit Smoker");
        this.block = Block.get(BlockID.LIT_SMOKER, meta);
    }
}