package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDarkOakPressurePlate extends Item {

    public ItemDarkOakPressurePlate() {
        this(0, 1);
    }

    public ItemDarkOakPressurePlate(Integer meta) {
        this(meta, 1);
    }

    public ItemDarkOakPressurePlate(Integer meta, int count) {
        super(ItemID.DARK_OAK_PRESSURE_PLATE, meta, count, "Dark Oak Pressure Plate");
        this.block = Block.get(BlockID.DARK_OAK_PRESSURE_PLATE, meta);
    }
}