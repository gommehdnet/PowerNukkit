package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.blockproperty.value.WoodType;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockStrippedOakLog extends BlockWoodStripped {
    @PowerNukkitOnly
    public BlockStrippedOakLog() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockStrippedOakLog(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.STRIPPED_OAK_LOG;
    }

    @PowerNukkitOnly
    @Override
    public WoodType getWoodType() {
        return WoodType.OAK;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.STRIPPED_OAK_LOG);
    }
}
