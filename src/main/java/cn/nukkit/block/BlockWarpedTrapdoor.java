package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockWarpedTrapdoor extends BlockTrapdoor {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockWarpedTrapdoor() {
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockWarpedTrapdoor(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.WARPED_TRAPDOOR;
    }
    
    @Override
    public String getName() {
        return "Warped Trapdoor";
    }
    
    @Override
    public int getBurnChance() {
        return 0;
    }
    
    @Override
    public int getBurnAbility() {
        return 0;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.CYAN_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WARPED_TRAPDOOR);
    }
}
