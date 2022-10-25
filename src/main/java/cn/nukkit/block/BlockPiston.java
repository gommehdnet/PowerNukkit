package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author CreeperFace
 */
@PowerNukkitDifference(since = "1.4.0.0-PN", info = "Implements BlockEntityHolder only in PowerNukkit")
public class BlockPiston extends BlockPistonBase {

    public BlockPiston() {
        this(0);
    }

    public BlockPiston(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.PISTON;
    }

    @Override
    public String getName() {
        return "Piston";
    }

    @PowerNukkitOnly
    @Override
    public BlockID getPistonHeadBlockId() {
        return BlockID.PISTON_ARM_COLLISION;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.PISTON);
    }
}
