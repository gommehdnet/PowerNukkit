package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockColoredTorchBp extends Block {

    @Override
    public BlockID getId() {
        return BlockID.COLORED_TORCH_BP;
    }

    @Override
    public String getName() {
        return "Colored Torch Bp";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.COLORED_TORCH_BP);
    }
}