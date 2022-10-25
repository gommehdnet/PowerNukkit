package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLightningRod extends Item {

    public ItemLightningRod() {
        this(0, 1);
    }

    public ItemLightningRod(Integer meta) {
        this(meta, 1);
    }

    public ItemLightningRod(Integer meta, int count) {
        super(ItemID.LIGHTNING_ROD, meta, count, "Lightning Rod");
        this.block = Block.get(BlockID.LIGHTNING_ROD, meta);
    }
}