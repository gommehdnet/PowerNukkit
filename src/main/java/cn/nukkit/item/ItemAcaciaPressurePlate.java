package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAcaciaPressurePlate extends Item {

    public ItemAcaciaPressurePlate() {
        this(0, 1);
    }

    public ItemAcaciaPressurePlate(Integer meta) {
        this(meta, 1);
    }

    public ItemAcaciaPressurePlate(Integer meta, int count) {
        super(ItemID.ACACIA_PRESSURE_PLATE, meta, count, "Acacia Pressure Plate");
        this.block = Block.get(BlockID.ACACIA_PRESSURE_PLATE, meta);
    }
}