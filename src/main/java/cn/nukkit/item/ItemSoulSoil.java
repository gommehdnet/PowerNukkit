package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSoulSoil extends Item {

    public ItemSoulSoil() {
        this(0, 1);
    }

    public ItemSoulSoil(Integer meta) {
        this(meta, 1);
    }

    public ItemSoulSoil(Integer meta, int count) {
        super(ItemID.SOUL_SOIL, meta, count, "Soul Soil");
        this.block = Block.get(BlockID.SOUL_SOIL, meta);
    }
}