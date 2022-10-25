package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.blockproperty.value.WoodType;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockStrippedAcaciaLog extends BlockWoodStripped {

    @PowerNukkitOnly
    public BlockStrippedAcaciaLog() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockStrippedAcaciaLog(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.STRIPPED_ACACIA_LOG;
    }

    @PowerNukkitOnly
    @Override
    public WoodType getWoodType() {
        return WoodType.ACACIA;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.STRIPPED_ACACIA_LOG);
    }
}
