package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAzalea extends Item {

    public ItemAzalea() {
        this(0, 1);
    }

    public ItemAzalea(Integer meta) {
        this(meta, 1);
    }

    public ItemAzalea(Integer meta, int count) {
        super(ItemID.AZALEA, meta, count, "Azalea");
        this.block = Block.get(BlockID.AZALEA, meta);
    }
}