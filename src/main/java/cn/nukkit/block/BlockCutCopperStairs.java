package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.network.protocol.LevelEventPacket;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCutCopperStairs extends BlockStairs {

    public BlockCutCopperStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.CUT_COPPER_STAIRS;
    }

    @Override
    public String getName() {
        return "Cut Copper Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CUT_COPPER_STAIRS);
    }

    @Override
    public boolean onActivate(@Nonnull Item item, @Nullable Player player) {
        if (item.getIdentifier().equals(ItemID.HONEYCOMB)) {
            this.getLevel().setBlock(this, Block.get(BlockID.WAXED_CUT_COPPER_STAIRS), true, true);
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