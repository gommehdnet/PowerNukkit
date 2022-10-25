package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOxidizedCopper extends Item {

    public ItemOxidizedCopper() {
        this(0, 1);
    }

    public ItemOxidizedCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemOxidizedCopper(Integer meta, int count) {
        super(ItemID.OXIDIZED_COPPER, meta, count, "Oxidized Copper");
        this.block = Block.get(BlockID.OXIDIZED_COPPER, meta);
    }
}