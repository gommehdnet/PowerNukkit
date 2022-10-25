package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockPolishedBlackstoneStairs extends BlockBlackstoneStairs {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstoneStairs() {
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstoneStairs(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Polished Blackstone Stairs";
    }

    @Override
    public BlockID getId() {
        return BlockID.POLISHED_BLACKSTONE_STAIRS;
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BLACKSTONE_STAIRS);
    }
}
