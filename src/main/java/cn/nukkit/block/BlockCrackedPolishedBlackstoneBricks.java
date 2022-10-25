package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockCrackedPolishedBlackstoneBricks extends BlockPolishedBlackstoneBricks {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockCrackedPolishedBlackstoneBricks() {
        // Does nothing
    }

    @Override
    public BlockID getId() {
        return BlockID.CRACKED_POLISHED_BLACKSTONE_BRICKS;
    }

    @Override
    public String getName() {
        return "Cracked Polished Blackstone Bricks";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CRACKED_POLISHED_BLACKSTONE_BRICKS);
    }
}
