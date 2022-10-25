package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author CreeperFace
 */
@PowerNukkitDifference(since = "1.4.0.0-PN", info = "Implements BlockEntityHolder only in PowerNukkit")
public class BlockStickyPiston extends BlockPistonBase {

    public BlockStickyPiston() {
        this(0);
    }

    public BlockStickyPiston(int meta) {
        super(meta);
        this.sticky = true;
    }

    @Override
    public BlockID getId() {
        return BlockID.STICKY_PISTON;
    }

    @Override
    public String getName() {
        return "Sticky Piston";
    }

    @PowerNukkitOnly
    @Override
    public BlockID getPistonHeadBlockId() {
        return BlockID.STICKY_PISTON_ARM_COLLISION;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.STICKY_PISTON);
    }
}
