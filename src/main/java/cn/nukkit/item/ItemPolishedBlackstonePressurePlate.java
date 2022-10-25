package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemPolishedBlackstonePressurePlate extends Item {

    public ItemPolishedBlackstonePressurePlate() {
        this(0, 1);
    }

    public ItemPolishedBlackstonePressurePlate(Integer meta) {
        this(meta, 1);
    }

    public ItemPolishedBlackstonePressurePlate(Integer meta, int count) {
        super(ItemID.POLISHED_BLACKSTONE_PRESSURE_PLATE, meta, count, "Polished Blackstone Pressure Plate");
        this.block = Block.get(BlockID.POLISHED_BLACKSTONE_PRESSURE_PLATE, meta);
    }
}