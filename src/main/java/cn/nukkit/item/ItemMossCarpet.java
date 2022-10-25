package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMossCarpet extends Item {

    public ItemMossCarpet() {
        this(0, 1);
    }

    public ItemMossCarpet(Integer meta) {
        this(meta, 1);
    }

    public ItemMossCarpet(Integer meta, int count) {
        super(ItemID.MOSS_CARPET, meta, count, "Moss Carpet");
        this.block = Block.get(BlockID.MOSS_CARPET, meta);
    }
}