package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author joserobjr
 */
@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockChiseledNetherBricks extends BlockNetherBrick {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockChiseledNetherBricks() {
        // Does nothing
    }

    @Override
    public BlockID getId() {
        return BlockID.CHISELED_NETHER_BRICKS;
    }

    @Override
    public String getName() {
        return "Chiseled Nether Bricks";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CHISELED_NETHER_BRICKS);
    }
}
