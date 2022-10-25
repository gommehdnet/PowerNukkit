package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemRespawnAnchor extends Item {

    public ItemRespawnAnchor() {
        this(0, 1);
    }

    public ItemRespawnAnchor(Integer meta) {
        this(meta, 1);
    }

    public ItemRespawnAnchor(Integer meta, int count) {
        super(ItemID.RESPAWN_ANCHOR, meta, count, "Respawn Anchor");
        this.block = Block.get(BlockID.RESPAWN_ANCHOR, meta);
    }
}