package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.math.BlockFace;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockAzalea extends BlockTransparentMeta {

    private final List<BlockID> plantingBlockIds = Arrays.asList(BlockID.DIRT, BlockID.GRASS, BlockID.PODZOL,
            BlockID.MYCELIUM, BlockID.DIRT_WITH_ROOTS, BlockID.MOSS_BLOCK, BlockID.MUD);

    @Override
    public BlockID getId() {
        return BlockID.AZALEA;
    }

    @Override
    public String getName() {
        return "Azalea";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.AZALEA);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return CommonBlockProperties.EMPTY_PROPERTIES;
    }

    @Override
    public int getBurnChance() {
        return 30;
    }

    @Override
    public int getBurnAbility() {
        return 60;
    }

    @Override
    public boolean place(@Nonnull Item item, @Nonnull Block block, @Nonnull Block target, @Nonnull BlockFace face, double fx, double fy, double fz, @Nullable Player player) {
        if (this.plantingBlockIds.contains(target.getId())) {
            return super.place(item, block, target, face, fx, fy, fz, player);
        }

        return false;
    }
}