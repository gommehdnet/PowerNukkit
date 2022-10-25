package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemChorusPlant extends Item {

    public ItemChorusPlant() {
        this(0, 1);
    }

    public ItemChorusPlant(Integer meta) {
        this(meta, 1);
    }

    public ItemChorusPlant(Integer meta, int count) {
        super(ItemID.CHORUS_PLANT, meta, count, "Chorus Plant");
        this.block = Block.get(BlockID.CHORUS_PLANT, meta);
    }
}