package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPowderSnow extends Item {

    public ItemPowderSnow() {
        this(0, 1);
    }

    public ItemPowderSnow(Integer meta) {
        this(meta, 1);
    }

    public ItemPowderSnow(Integer meta, int count) {
        super(ItemID.POWDER_SNOW, meta, count, "Powder Snow");
        this.block = Block.get(BlockID.POWDER_SNOW, meta);
    }
}