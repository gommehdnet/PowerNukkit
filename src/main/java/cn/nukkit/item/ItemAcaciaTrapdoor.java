package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAcaciaTrapdoor extends Item {

    public ItemAcaciaTrapdoor() {
        this(0, 1);
    }

    public ItemAcaciaTrapdoor(Integer meta) {
        this(meta, 1);
    }

    public ItemAcaciaTrapdoor(Integer meta, int count) {
        super(ItemID.ACACIA_TRAPDOOR, meta, count, "Acacia Trapdoor");
        this.block = Block.get(BlockID.ACACIA_TRAPDOOR, meta);
    }
}