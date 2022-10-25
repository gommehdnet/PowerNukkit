package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.blockproperty.value.WoodType;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockStrippedDarkOakLog extends BlockWoodStripped {
    @PowerNukkitOnly
    public BlockStrippedDarkOakLog() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockStrippedDarkOakLog(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.STRIPPED_DARK_OAK_LOG;
    }

    @PowerNukkitOnly
    @Override
    public WoodType getWoodType() {
        return WoodType.DARK_OAK;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.STRIPPED_DARK_OAK_LOG);
    }
}
