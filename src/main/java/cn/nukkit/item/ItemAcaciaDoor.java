package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAcaciaDoor extends Item {

    public ItemAcaciaDoor() {
        this(0, 1);
    }

    public ItemAcaciaDoor(Integer meta) {
        this(meta, 1);
    }

    public ItemAcaciaDoor(Integer meta, int count) {
        super(ItemID.ACACIA_DOOR, 0, count, "Acacia Door");
        this.block = Block.get(BlockID.ACACIA_DOOR, meta);
    }
}