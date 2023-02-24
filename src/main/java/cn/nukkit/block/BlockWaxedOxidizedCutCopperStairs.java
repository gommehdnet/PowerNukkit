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
public class BlockWaxedOxidizedCutCopperStairs extends BlockStairs {

    public BlockWaxedOxidizedCutCopperStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.WAXED_OXIDIZED_CUT_COPPER_STAIRS;
    }

    @Override
    public String getName() {
        return "Waxed Oxidized Cut Copper Stairs";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WAXED_OXIDIZED_CUT_COPPER_STAIRS);
    }

    @Override
    public boolean onActivate(@Nonnull Item item, @Nullable Player player) {
        if (item.isAxe()) {
            this.getLevel().setBlock(this, Block.get(BlockID.OXIDIZED_CUT_COPPER_STAIRS), true, true);
            this.getLevel().addLevelEvent(this, LevelEventPacket.EVENT_PARTICLE_SCRAPE);
        }

        return true;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }
}