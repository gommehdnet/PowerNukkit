package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author CreeperFace
 */
@PowerNukkitDifference(since = "1.4.0.0-PN", info = "Implements BlockEntityHolder only in PowerNukkit")
public class BlockPoweredComparator extends BlockRedstoneComparator {

    public BlockPoweredComparator() {
        this(0);
    }

    public BlockPoweredComparator(int meta) {
        super(meta);
        this.isPowered = true;
    }

    @Override
    public BlockID getId() {
        return BlockID.POWERED_COMPARATOR;
    }

    @Override
    public String getName() {
        return "Comparator Block Powered";
    }

    @Override
    protected BlockRedstoneComparator getPowered() {
        return this;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.UNPOWERED_COMPARATOR);
    }
}
