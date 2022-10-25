package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBuddingAmethyst extends Item {

    public ItemBuddingAmethyst() {
        this(0, 1);
    }

    public ItemBuddingAmethyst(Integer meta) {
        this(meta, 1);
    }

    public ItemBuddingAmethyst(Integer meta, int count) {
        super(ItemID.BUDDING_AMETHYST, meta, count, "Budding Amethyst");
        this.block = Block.get(BlockID.BUDDING_AMETHYST, meta);
    }
}