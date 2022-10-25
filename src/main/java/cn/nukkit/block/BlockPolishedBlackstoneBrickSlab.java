package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockPolishedBlackstoneBrickSlab extends BlockPolishedBlackstoneSlab {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstoneBrickSlab() {
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstoneBrickSlab(int meta) {
        super(meta, BlockID.POLISHED_BLACKSTONE_BRICK_DOUBLE_SLAB);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    protected BlockPolishedBlackstoneBrickSlab(int meta, BlockID doubleSlab) {
        super(meta, doubleSlab);
    }

    @Override
    public BlockID getId() {
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
