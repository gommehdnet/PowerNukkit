package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCrackedDeepslateTiles extends Block {

    @Override
    public BlockID getId() {
        return BlockID.CRACKED_DEEPSLATE_TILES;
    }

    @Override
    public String getName() {
        return "Cracked Deepslate Tiles";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CRACKED_DEEPSLATE_TILES);
    }
}