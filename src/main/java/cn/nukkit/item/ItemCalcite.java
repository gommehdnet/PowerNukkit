package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCalcite extends Item {

    public ItemCalcite() {
        this(0, 1);
    }

    public ItemCalcite(Integer meta) {
        this(meta, 1);
    }

    public ItemCalcite(Integer meta, int count) {
        super(ItemID.CALCITE, meta, count, "Calcite");
        this.block = Block.get(BlockID.CALCITE, meta);
    }
}