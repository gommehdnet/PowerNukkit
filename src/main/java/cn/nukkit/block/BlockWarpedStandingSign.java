package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemWarpedSign;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockWarpedStandingSign extends BlockStandingSign {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockWarpedStandingSign() {
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockWarpedStandingSign(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.WARPED_STANDING_SIGN;
    }

    @PowerNukkitOnly
    @Override
    public BlockID getWallId() {
        return BlockID.WARPED_WALL_SIGN;
    }

    @Override
    public String getName() {
        return "Warped Sign Post";
    }

    @Override
    public Item toItem() {
        return new ItemWarpedSign();
    }
    
    @Override
    public int getBurnChance() {
        return 0;
    }
    
    @Override
    public int getBurnAbility() {
        return 0;
    }
}
