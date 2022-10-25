package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.blockproperty.value.WoodType;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockStrippedJungleLog extends BlockWoodStripped {
    @PowerNukkitOnly
    public BlockStrippedJungleLog() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockStrippedJungleLog(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.STRIPPED_JUNGLE_LOG;
    }

    @PowerNukkitOnly
    @Override
    public WoodType getWoodType() {
        return WoodType.JUNGLE;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.STRIPPED_JUNGLE_LOG);
    }
}
