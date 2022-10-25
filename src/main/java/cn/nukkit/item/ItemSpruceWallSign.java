package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemSpruceWallSign extends Item {

    public ItemSpruceWallSign() {
        this(0, 1);
    }

    public ItemSpruceWallSign(Integer meta) {
        this(meta, 1);
    }

    public ItemSpruceWallSign(Integer meta, int count) {
        super(ItemID.SPRUCE_WALL_SIGN, meta, count, "Spruce Wall Sign");
        this.block = Block.get(BlockID.SPRUCE_WALL_SIGN, meta);
    }
}