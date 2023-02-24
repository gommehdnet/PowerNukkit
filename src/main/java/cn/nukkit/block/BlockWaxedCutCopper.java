package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.network.protocol.LevelEventPacket;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockWaxedCutCopper extends Block {

    @Override
    public BlockID getId() {
        return BlockID.WAXED_CUT_COPPER;
    }

    @Override
    public String getName() {
        return "Waxed Cut Copper";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WAXED_CUT_COPPER);
    }

    @Override
    public double getHardness() {
        return 3;
    }

    @Override
    public double getResistance() {
        return 6;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getToolTier() {
        return ItemTool.TIER_STONE;
    }

    @Override
    public Item[] getDrops(Item item) {
        if (item.isPickaxe()) {
            return new Item[]{this.toItem()};
        }

        return Item.EMPTY_ARRAY;
    }

    @Override
    public boolean onActivate(@Nonnull Item item, @Nullable Player player) {
        if (item.isAxe()) {
            this.getLevel().setBlock(this, Block.get(BlockID.CUT_COPPER), true, true);
            this.getLevel().addLevelEvent(this, LevelEventPacket.EVENT_PARTICLE_WAX_OFF);
        }

        return true;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }
}