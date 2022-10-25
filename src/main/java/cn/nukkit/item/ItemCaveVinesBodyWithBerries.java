package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCaveVinesBodyWithBerries extends Item {

    public ItemCaveVinesBodyWithBerries() {
        this(0, 1);
    }

    public ItemCaveVinesBodyWithBerries(Integer meta) {
        this(meta, 1);
    }

    public ItemCaveVinesBodyWithBerries(Integer meta, int count) {
        super(ItemID.CAVE_VINES_BODY_WITH_BERRIES, meta, count, "Cave Vines Body With Berries");
        this.block = Block.get(BlockID.CAVE_VINES_BODY_WITH_BERRIES, meta);
    }
}