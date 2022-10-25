package cn.nukkit.block;


import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockChiseledPolishedBlackstone extends BlockPolishedBlackstone {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockChiseledPolishedBlackstone() {
        // Does nothing
    }

    @Override
    public BlockID getId() {
        return BlockID.CHISELED_POLISHED_BLACKSTONE;
    }

    @Override
    public String getName() {
        return "Chiseled Polished Blackstone";
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CHISELED_POLISHED_BLACKSTONE);
    }
}
