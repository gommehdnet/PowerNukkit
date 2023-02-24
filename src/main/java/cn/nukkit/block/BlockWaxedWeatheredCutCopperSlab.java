package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.network.protocol.LevelEventPacket;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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

    @Override
    public boolean onActivate(@Nonnull Item item, @Nullable Player player) {
        if (item.isAxe()) {
            this.getLevel().setBlock(this, Block.get(BlockID.WEATHERED_CUT_COPPER_SLAB), true, true);
            this.getLevel().addLevelEvent(this, LevelEventPacket.EVENT_PARTICLE_SCRAPE);
        }

        return true;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }
}