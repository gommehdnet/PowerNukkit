package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemVerdantFroglight extends Item {

    public ItemVerdantFroglight() {
        this(0, 1);
    }

    public ItemVerdantFroglight(Integer meta) {
        this(meta, 1);
    }

    public ItemVerdantFroglight(Integer meta, int count) {
        super(ItemID.VERDANT_FROGLIGHT, meta, count, "Verdant Froglight");
        this.block = Block.get(BlockID.VERDANT_FROGLIGHT, meta);
    }
}