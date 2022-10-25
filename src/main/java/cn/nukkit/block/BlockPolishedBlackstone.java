package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockPolishedBlackstone extends BlockBlackstone {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstone() {
        // Does nothing
    }

    @Override
    public String getName() {
        return "Polished Blackstone";
    }

    @Override
    public BlockID getId() {
        return BlockID.POLISHED_BLACKSTONE;
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.POLISHED_BLACKSTONE);
    }
}
