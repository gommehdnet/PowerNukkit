package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockPolishedBlackstoneWall extends BlockWallBase {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstoneWall() {
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstoneWall(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.POLISHED_BLACKSTONE_WALL;
    }

    @Override
    public String getName() {
        return "Polished Blackstone Wall";
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getToolTier() {
        return ItemTool.TIER_WOODEN;
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public double getResistance() {
        return 6.0;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.BLACK_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.POLISHED_BLACKSTONE_WALL);
    }
}
