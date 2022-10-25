package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemStick;
import cn.nukkit.level.Level;
import cn.nukkit.math.BlockFace;
import cn.nukkit.utils.BlockColor;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author xtypr
 * @since 2015/12/2
 */
public class BlockDeadbush extends BlockFlowable {
    public BlockDeadbush() {
        this(0);
    }

    public BlockDeadbush(int meta) {
        // Dead bushes can't have meta. Also stops the server from throwing an exception with the block palette.
        super(0);
    }

    @Override
    public String getName() {
        return "Dead Bush";
    }

    @Override
    public BlockID getId() {
        return BlockID.DEADBUSH;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return CommonBlockProperties.EMPTY_PROPERTIES;
    }

    @PowerNukkitOnly
    @Override
    public int getWaterloggingLevel() {
        return 1;
    }

    @Override
    public boolean canBeReplaced() {
        return true;
    }

    @PowerNukkitDifference(since = "1.4.0.0-PN", info = "Fixed support logic")
    @Override
    public boolean place(@Nonnull Item item, @Nonnull Block block, @Nonnull Block target, @Nonnull BlockFace face, double fx, double fy, double fz, Player player) {
        if (isSupportValid()) {
            this.getLevel().setBlock(block, this, true, true);
            return true;
        }
        return false;
    }

    private final List<BlockID> terracottaIds = Arrays.asList(BlockID.BLACK_GLAZED_TERRACOTTA, BlockID.BLUE_GLAZED_TERRACOTTA,
            BlockID.BROWN_GLAZED_TERRACOTTA, BlockID.CYAN_GLAZED_TERRACOTTA, BlockID.GRAY_GLAZED_TERRACOTTA,
            BlockID.GREEN_GLAZED_TERRACOTTA, BlockID.LIGHT_BLUE_GLAZED_TERRACOTTA, BlockID.LIME_GLAZED_TERRACOTTA,
            BlockID.MAGENTA_GLAZED_TERRACOTTA, BlockID.ORANGE_GLAZED_TERRACOTTA, BlockID.PINK_GLAZED_TERRACOTTA,
            BlockID.PURPLE_GLAZED_TERRACOTTA, BlockID.RED_GLAZED_TERRACOTTA, BlockID.SILVER_GLAZED_TERRACOTTA,
            BlockID.WHITE_GLAZED_TERRACOTTA, BlockID.YELLOW_GLAZED_TERRACOTTA);

    private boolean isSupportValid() {
        return down().getId().equals(BlockID.SAND) || this.terracottaIds.contains(down().getId()) ||
                down().getId().equals(BlockID.DIRT) || down().getId().equals(BlockID.PODZOL);
    }

    @PowerNukkitDifference(since = "1.4.0.0-PN", info = "Fixed support logic")
    @Override
    public int onUpdate(int type) {
        if (type == Level.BLOCK_UPDATE_NORMAL) {
            if (!isSupportValid()) {
                this.getLevel().useBreakOn(this);

                return Level.BLOCK_UPDATE_NORMAL;
            }
        }
        return 0;
    }

    @Override
    public Item[] getDrops(Item item) {
        if (item.isShears()) {
            return new Item[]{
                    toItem()
            };
        } else {
            return new Item[]{
                    new ItemStick(new Random().nextInt(3))
            };
        }
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.FOLIAGE_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEADBUSH);
    }
}
