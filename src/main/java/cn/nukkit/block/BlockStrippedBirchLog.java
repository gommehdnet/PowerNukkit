package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.blockproperty.value.WoodType;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockStrippedBirchLog extends BlockWoodStripped {
    @PowerNukkitOnly
    public BlockStrippedBirchLog() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockStrippedBirchLog(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.STRIPPED_BIRCH_LOG;
    }

    @PowerNukkitOnly
    @Override
    public WoodType getWoodType() {
        return WoodType.BIRCH;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.STRIPPED_BIRCH_LOG);
    }
}
