package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateTiles extends Block {

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_TILES;
    }

    @Override
    public String getName() {
        return "Deepslate Tiles";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_TILES);
    }
}