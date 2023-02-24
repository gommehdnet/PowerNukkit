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
public class BlockOxidizedCutCopperSlab extends BlockSlab {

    public BlockOxidizedCutCopperSlab(int meta) {
        super(meta, BlockID.OXIDIZED_DOUBLE_CUT_COPPER_SLAB);
    }

    @Override
    public BlockID getId() {
        return BlockID.OXIDIZED_CUT_COPPER_SLAB;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public String getSlabName() {
        return "Oxidized Cut Copper";
    }

    @Override
    public String getName() {
        return "Oxidized Cut Copper Slab";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public boolean isSameType(BlockSlab slab) {
        return this.getId().equals(slab.getId());
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.OXIDIZED_CUT_COPPER_SLAB);
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
        if (item.getIdentifier().equals(ItemID.HONEYCOMB)) {
            this.getLevel().setBlock(this, Block.get(BlockID.WAXED_OXIDIZED_CUT_COPPER_SLAB), true, true);
            this.getLevel().addLevelEvent(this, LevelEventPacket.EVENT_PARTICLE_WAX_ON);

            if (player != null && !player.isCreative()) {
                item.setCount(item.getCount() - 1);
            }
        }

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