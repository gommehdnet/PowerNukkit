package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockUnderwaterTorch extends Block {

    @Override
    public BlockID getId() {
        return BlockID.UNDERWATER_TORCH;
    }

    @Override
    public String getName() {
        return "Underwater Torch";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.UNDERWATER_TORCH);
    }
}