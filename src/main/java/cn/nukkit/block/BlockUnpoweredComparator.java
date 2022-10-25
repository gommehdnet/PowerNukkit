package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author CreeperFace
 */
@PowerNukkitDifference(since = "1.4.0.0-PN", info = "Implements BlockEntityHolder only in PowerNukkit")
public class BlockUnpoweredComparator extends BlockRedstoneComparator {

    public BlockUnpoweredComparator() {
        this(0);
    }

    public BlockUnpoweredComparator(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.UNPOWERED_COMPARATOR;
    }

    @Override
    public String getName() {
        return "Comparator Block Unpowered";
    }

    @Override
    protected BlockRedstoneComparator getUnpowered() {
        return this;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.COMPARATOR);
    }
}
