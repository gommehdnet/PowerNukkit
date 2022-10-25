package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOchreFroglight extends Item {

    public ItemOchreFroglight() {
        this(0, 1);
    }

    public ItemOchreFroglight(Integer meta) {
        this(meta, 1);
    }

    public ItemOchreFroglight(Integer meta, int count) {
        super(ItemID.OCHRE_FROGLIGHT, meta, count, "Ochre Froglight");
        this.block = Block.get(BlockID.OCHRE_FROGLIGHT, meta);
    }
}