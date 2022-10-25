package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.blockproperty.value.WoodType;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockStrippedSpruceLog extends BlockWoodStripped {
    @PowerNukkitOnly
    public BlockStrippedSpruceLog() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockStrippedSpruceLog(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.STRIPPED_SPRUCE_LOG;
    }

    @PowerNukkitOnly
    @Override
    public WoodType getWoodType() {
        return WoodType.SPRUCE;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.STRIPPED_SPRUCE_LOG);
    }
}
