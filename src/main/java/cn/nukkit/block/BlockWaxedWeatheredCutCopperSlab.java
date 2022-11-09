package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWaxedWeatheredCutCopperSlab extends BlockSlab {

    public BlockWaxedWeatheredCutCopperSlab(int meta) {
        super(meta, BlockID.WAXED_WEATHERED_DOUBLE_CUT_COPPER_SLAB);
    }

    @Override
    public BlockID getId() {
        return BlockID.WAXED_WEATHERED_CUT_COPPER_SLAB;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public String getSlabName() {
        return "Waxed Weathered Cut Copper";
    }

    @Override
    public String getName() {
        return "Waxed Weathered Cut Copper Slab";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public boolean isSameType(BlockSlab slab) {
        return this.getId().equals(slab.getId());
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WAXED_WEATHERED_CUT_COPPER_SLAB, 0, 2);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return SIMPLE_SLAB_PROPERTIES;
    }
}