package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateTileStairs extends BlockStairs {

    protected BlockDeepslateTileStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_TILE_STAIRS;
    }

    @Override
    public String getName() {
        return "Deepslate Tile Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_TILE_STAIRS);
    }
}