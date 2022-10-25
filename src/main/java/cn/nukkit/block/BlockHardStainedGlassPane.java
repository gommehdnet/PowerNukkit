package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockHardStainedGlassPane extends Block {

    @Override
    public BlockID getId() {
        return BlockID.HARD_STAINED_GLASS_PANE;
    }

    @Override
    public String getName() {
        return "Hard Stained Glass Pane";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.HARD_STAINED_GLASS_PANE);
    }
}