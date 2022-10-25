package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGlowLichen extends Item {

    public ItemGlowLichen() {
        this(0, 1);
    }

    public ItemGlowLichen(Integer meta) {
        this(meta, 1);
    }

    public ItemGlowLichen(Integer meta, int count) {
        super(ItemID.GLOW_LICHEN, meta, count, "Glow Lichen");
        this.block = Block.get(BlockID.GLOW_LICHEN, meta);
    }
}