package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOxidizedCutCopper extends Item {

    public ItemOxidizedCutCopper() {
        this(0, 1);
    }

    public ItemOxidizedCutCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemOxidizedCutCopper(Integer meta, int count) {
        super(ItemID.OXIDIZED_CUT_COPPER, meta, count, "Oxidized Cut Copper");
        this.block = Block.get(BlockID.OXIDIZED_CUT_COPPER, meta);
    }
}