package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.network.protocol.LevelEventPacket;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockExposedDoubleCutCopperSlab extends BlockDoubleSlabBase {

    public BlockExposedDoubleCutCopperSlab(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.EXPOSED_DOUBLE_CUT_COPPER_SLAB;
    }

    @Override
    public String getName() {
        return "Exposed Double Cut Copper Slab";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public String getSlabName() {
        return "Exposed Cut Copper";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public BlockID getSingleSlabId() {
        return BlockID.EXPOSED_CUT_COPPER_SLAB;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.EXPOSED_DOUBLE_CUT_COPPER_SLAB);
    }

    @Override
    public boolean onActivate(@Nonnull Item item, @Nullable Player player) {
        if (item.getIdentifier().equals(ItemID.HONEYCOMB)) {
            this.getLevel().setBlock(this, Block.get(BlockID.WAXED_EXPOSED_DOUBLE_CUT_COPPER_SLAB), true, true);
            this.getLevel().addLevelEvent(this, LevelEventPacket.EVENT_PARTICLE_WAX_ON);

            if (player != null && !player.isCreative()) {
                item.setCount(item.getCount() - 1);
            }
        }

        if (item.isAxe()) {
            this.getLevel().setBlock(this, Block.get(BlockID.DOUBLE_CUT_COPPER_SLAB), true, true);
            this.getLevel().addLevelEvent(this, LevelEventPacket.EVENT_PARTICLE_SCRAPE);
        }

        return true;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }
}