package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockPolishedBlackstoneBrickDoubleSlab extends BlockPolishedBlackstoneDoubleSlab {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstoneBrickDoubleSlab() {
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstoneBrickDoubleSlab(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.POLISHED_BLACKSTONE_BRICK_DOUBLE_SLAB;
    }

    @PowerNukkitOnly
    @Override
    public BlockID getSingleSlabId() {
        return BlockID.POLISHED_BLACKSTONE_BRICK_SLAB;
    }

    @PowerNukkitOnly
    @Override
    public String getSlabName() {
        return "Polished Blackstone Brick";
    }

    @Override
    public double getHardness() {
        return 2;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.POLISHED_BLACKSTONE_BRICK_SLAB);
    }
}
