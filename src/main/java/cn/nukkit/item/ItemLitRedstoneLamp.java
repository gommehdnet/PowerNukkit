package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemLitRedstoneLamp extends Item {

    public ItemLitRedstoneLamp() {
        this(0, 1);
    }

    public ItemLitRedstoneLamp(Integer meta) {
        this(meta, 1);
    }

    public ItemLitRedstoneLamp(Integer meta, int count) {
        super(ItemID.LIT_REDSTONE_LAMP, meta, count, "Lit Redstone Lamp");
        this.block = Block.get(BlockID.LIT_REDSTONE_LAMP, meta);
    }
}