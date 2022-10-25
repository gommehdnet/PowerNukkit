package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockPolishedBlackstoneDoubleSlab extends BlockDoubleSlabBase {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstoneDoubleSlab() {
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstoneDoubleSlab(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.POLISHED_BLACKSTONE_DOUBLE_SLAB;
    }

    @PowerNukkitOnly
    @Override
    public BlockID getSingleSlabId() {
        return BlockID.POLISHED_BLACKSTONE_SLAB;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.POLISHED_BLACKSTONE_SLAB);
    }

    @PowerNukkitOnly
    @Override
    public String getSlabName() {
        return "Polished Blackstone";
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public double getHardness() {
        return 2;
    }

    @Override
    public double getResistance() {
        return 6.0;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.BLACK_BLOCK_COLOR;
    }
}
