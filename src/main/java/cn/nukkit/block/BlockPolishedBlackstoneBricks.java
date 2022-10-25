package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockPolishedBlackstoneBricks extends BlockPolishedBlackstone {

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstoneBricks() {
        // Does nothing
    }

    @Override
    public BlockID getId() {
        return BlockID.POLISHED_BLACKSTONE_BRICKS;
    }

    @Override
    public String getName() {
        return "Polished Blackstone Bricks";
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.POLISHED_BLACKSTONE_BRICKS);
    }
}
