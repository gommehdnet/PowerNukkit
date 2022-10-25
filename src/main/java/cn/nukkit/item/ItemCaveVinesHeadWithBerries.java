package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCaveVinesHeadWithBerries extends Item {

    public ItemCaveVinesHeadWithBerries() {
        this(0, 1);
    }

    public ItemCaveVinesHeadWithBerries(Integer meta) {
        this(meta, 1);
    }

    public ItemCaveVinesHeadWithBerries(Integer meta, int count) {
        super(ItemID.CAVE_VINES_HEAD_WITH_BERRIES, meta, count, "Cave Vines Head With Berries");
        this.block = Block.get(BlockID.CAVE_VINES_HEAD_WITH_BERRIES, meta);
    }
}