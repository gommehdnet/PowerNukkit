package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMediumAmethystBud extends Item {

    public ItemMediumAmethystBud() {
        this(0, 1);
    }

    public ItemMediumAmethystBud(Integer meta) {
        this(meta, 1);
    }

    public ItemMediumAmethystBud(Integer meta, int count) {
        super(ItemID.MEDIUM_AMETHYST_BUD, meta, count, "Medium Amethyst Bud");
        this.block = Block.get(BlockID.MEDIUM_AMETHYST_BUD, meta);
    }
}