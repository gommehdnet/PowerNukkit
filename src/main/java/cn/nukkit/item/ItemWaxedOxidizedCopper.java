package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemWaxedOxidizedCopper extends Item {

    public ItemWaxedOxidizedCopper() {
        this(0, 1);
    }

    public ItemWaxedOxidizedCopper(Integer meta) {
        this(meta, 1);
    }

    public ItemWaxedOxidizedCopper(Integer meta, int count) {
        super(ItemID.WAXED_OXIDIZED_COPPER, meta, count, "Waxed Oxidized Copper");
        this.block = Block.get(BlockID.WAXED_OXIDIZED_COPPER, meta);
    }
}