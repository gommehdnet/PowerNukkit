package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.math.BlockFace;
import cn.nukkit.utils.BlockColor;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Pub4Game
 * @since 2015/12/26
 */
public class BlockNetherrack extends BlockSolid {

    public BlockNetherrack() {
    }

    @Override
    public BlockID getId() {
        return BlockID.NETHERRACK;
    }

    @Override
    public double getResistance() {
        return 2;
    }

    @Override
    public double getHardness() {
        return 0.4;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public String getName() {
        return "Netherrack";
    }

    @Override
    @PowerNukkitOnly
    public int getToolTier() {
        return ItemTool.TIER_WOODEN;
    }

    @Override
    public boolean onActivate(@Nonnull Item item, @Nullable Player player) {
        if (item.isNull() || !item.isFertilizer() || up().getId() != BlockID.AIR) {
            return false;
        }

        List<BlockID> options = new ObjectArrayList<>();
        for(BlockFace face: BlockFace.Plane.HORIZONTAL) {
            BlockID id = getSide(face).getId();
            if ((id == BlockID.CRIMSON_NYLIUM || id == BlockID.WARPED_NYLIUM) && !options.contains(id)) {
                options.add(id);
            }
        }

        BlockID nylium;
        int size = options.size();
        if (size == 0) {
            return false;
        } else if (size == 1) {
            nylium = options.get(0);
        } else {
            nylium = options.get(ThreadLocalRandom.current().nextInt(size));
        }
        
        if (level.setBlock(this, Block.get(nylium), true)) {
            if (player == null || !player.isCreative()) {
                item.count--;
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.NETHERRACK_BLOCK_COLOR;
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.NETHERRACK);
    }

}
