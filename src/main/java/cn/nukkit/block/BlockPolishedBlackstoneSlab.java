package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.utils.BlockColor;

import javax.annotation.Nonnull;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockPolishedBlackstoneSlab extends BlockSlab {

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstoneSlab() {
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockPolishedBlackstoneSlab(int meta) {
        super(meta, BlockID.POLISHED_BLACKSTONE_DOUBLE_SLAB);
    }


    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    protected BlockPolishedBlackstoneSlab(int meta, BlockID doubleSlab) {
        super(meta, doubleSlab);
    }

    @Override
    public BlockID getId() {
        return BlockID.POLISHED_BLACKSTONE_SLAB;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return SIMPLE_SLAB_PROPERTIES;
    }

    @PowerNukkitOnly
    @Override
    public String getSlabName() {
        return "Polished Blackstone";
    }

    @PowerNukkitOnly
    @Override
    public boolean isSameType(BlockSlab slab) {
        return getId() == slab.getId();
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
    public Item[] getDrops(Item item) {
        if (item.isPickaxe() && item.getTier() >= ItemTool.TIER_WOODEN) {
            return new Item[]{ toItem() };
        }
        return Item.EMPTY_ARRAY;
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

    @Override
    public Item toItem() {
        return Item.get(ItemID.POLISHED_BLACKSTONE_SLAB);
    }
}
