package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemChemicalHeat extends Item {

    public ItemChemicalHeat() {
        this(0, 1);
    }

    public ItemChemicalHeat(Integer meta) {
        this(meta, 1);
    }

    public ItemChemicalHeat(Integer meta, int count) {
        super(ItemID.CHEMICAL_HEAT, meta, count, "Chemical Heat");
        this.block = Block.get(BlockID.CHEMICAL_HEAT, meta);
    }
}