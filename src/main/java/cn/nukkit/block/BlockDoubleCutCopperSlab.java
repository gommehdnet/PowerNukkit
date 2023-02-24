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
public class BlockDoubleCutCopperSlab extends BlockDoubleSlabBase {

    public BlockDoubleCutCopperSlab(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.DOUBLE_CUT_COPPER_SLAB;
    }

    @Override
    public String getName() {
        return "Double Cut Copper Slab";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public String getSlabName() {
        return "Cut Copper";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public BlockID getSingleSlabId() {
        return BlockID.CUT_COPPER_SLAB;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CUT_COPPER_SLAB);
    }

    @Override
    public boolean onActivate(@Nonnull Item item, @Nullable Player player) {
        if (item.getIdentifier().equals(ItemID.HONEYCOMB)) {
            this.getLevel().setBlock(this, Block.get(BlockID.WAXED_DOUBLE_CUT_COPPER_SLAB), true, true);
            this.getLevel().addLevelEvent(this, LevelEventPacket.EVENT_PARTICLE_WAX_ON);

            if (player != null && !player.isCreative()) {
                item.setCount(item.getCount() - 1);
            }
        }

        return true;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }
}