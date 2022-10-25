package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemFloweringAzalea extends Item {

    public ItemFloweringAzalea() {
        this(0, 1);
    }

    public ItemFloweringAzalea(Integer meta) {
        this(meta, 1);
    }

    public ItemFloweringAzalea(Integer meta, int count) {
        super(ItemID.FLOWERING_AZALEA, meta, count, "Flowering Azalea");
        this.block = Block.get(BlockID.FLOWERING_AZALEA, meta);
    }
}