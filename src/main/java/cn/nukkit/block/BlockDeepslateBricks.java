package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateBricks extends Block {

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_BRICKS;
    }

    @Override
    public String getName() {
        return "Deepslate Bricks";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_BRICKS);
    }
}