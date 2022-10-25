package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

/**
 * BlockFenceWarped.java was made by using BlockFence.java and BlockFenceNetherBrick.java
 */
/**
 * @author xtypr
 * @since 2015/12/7
 */
@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockWarpedFence extends BlockFenceBase {

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public BlockWarpedFence() {
        this(0);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public BlockWarpedFence(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Warped Fence";
    }

    @Override
    public BlockID getId() {
        return BlockID.WARPED_FENCE;
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
        return Item.get(ItemID.WARPED_FENCE);
    }
}
