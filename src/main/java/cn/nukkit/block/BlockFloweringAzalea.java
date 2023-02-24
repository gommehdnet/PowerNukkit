package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockFloweringAzalea extends BlockAzalea {

    @Override
    public BlockID getId() {
        return BlockID.FLOWERING_AZALEA;
    }

    @Override
    public String getName() {
        return "Flowering Azalea";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.FLOWERING_AZALEA);
    }
}