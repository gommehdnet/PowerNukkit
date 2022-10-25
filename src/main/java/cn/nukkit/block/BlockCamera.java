package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCamera extends Block {

    @Override
    public BlockID getId() {
        return BlockID.CAMERA;
    }

    @Override
    public String getName() {
        return "Camera";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CAMERA);
    }
}