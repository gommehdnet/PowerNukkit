package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemDarkOakTrapdoor extends Item {

    public ItemDarkOakTrapdoor() {
        this(0, 1);
    }

    public ItemDarkOakTrapdoor(Integer meta) {
        this(meta, 1);
    }

    public ItemDarkOakTrapdoor(Integer meta, int count) {
        super(ItemID.DARK_OAK_TRAPDOOR, meta, count, "Dark Oak Trapdoor");
        this.block = Block.get(BlockID.DARK_OAK_TRAPDOOR, meta);
    }
}