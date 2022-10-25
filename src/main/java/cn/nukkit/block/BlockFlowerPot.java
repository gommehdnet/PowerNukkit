package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockentity.BlockEntity;
import cn.nukkit.blockentity.BlockEntityFlowerPot;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemFlowerPot;
import cn.nukkit.item.ItemID;
import cn.nukkit.level.Level;
import cn.nukkit.math.AxisAlignedBB;
import cn.nukkit.math.BlockFace;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.Tag;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static cn.nukkit.block.BlockLeaves.UPDATE;

/**
 * @author Nukkit Project Team
 */
@PowerNukkitDifference(since = "1.4.0.0-PN", info = "Implements BlockEntityHolder only in PowerNukkit")
public class BlockFlowerPot extends BlockFlowable implements BlockEntityHolder<BlockEntityFlowerPot> {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static BlockProperties PROPERTIES = new BlockProperties(UPDATE);

    public BlockFlowerPot() {
        this(0);
    }

    public BlockFlowerPot(int meta) {
        super(meta);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    protected static boolean canPlaceIntoFlowerPot(ItemID id) {
        if (id.equals(ItemID.SAPLING) || id.equals(ItemID.DEADBUSH) || id.equals(ItemID.YELLOW_FLOWER) ||
                id.equals(ItemID.RED_FLOWER) || id.equals(ItemID.RED_MUSHROOM) || id.equals(ItemID.BROWN_MUSHROOM) ||
                id.equals(ItemID.CACTUS) || id.equals(ItemID.WITHER_ROSE) || id.equals(ItemID.WARPED_FUNGUS) ||
                id.equals(ItemID.CRIMSON_FUNGUS) || id.equals(ItemID.WARPED_ROOTS) || id.equals(ItemID.CRIMSON_ROOTS) || id.equals(ItemID.BAMBOO)) {
            return true;
        } else {
            return false;
        }
    }

    @PowerNukkitOnly
    @Override
    public int getWaterloggingLevel() {
        return 1;
    }

    @Override
    public String getName() {
        return "Flower Pot";
    }

    @Override
    public BlockID getId() {
        return BlockID.FLOWER_POT;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public Class<? extends BlockEntityFlowerPot> getBlockEntityClass() {
        return BlockEntityFlowerPot.class;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    @Override
    public String getBlockEntityType() {
        return BlockEntity.FLOWER_POT;
    }

    @Override
    public double getHardness() {
        return 0;
    }

    @Override
    public double getResistance() {
        return 0;
    }

    @PowerNukkitDifference(since = "1.4.0.0-PN", info = "Fixed support logic")
    @Override
    public int onUpdate(int type) {
        if (type == Level.BLOCK_UPDATE_NORMAL) {
            if (!BlockLever.isSupportValid(down(), BlockFace.UP)) {
                level.useBreakOn(this);
                return type;
            }
        }
        return 0;
    }

    @PowerNukkitDifference(since = "1.4.0.0-PN", info = "Fixed support logic")
    @Override
    public boolean place(@Nonnull Item item, @Nonnull Block block, @Nonnull Block target, @Nonnull BlockFace face, double fx, double fy, double fz, Player player) {
        if (!BlockLever.isSupportValid(down(), BlockFace.UP)) {
            return false;
        }

        CompoundTag nbt = new CompoundTag()
                .putShort("item", 0)
                .putInt("data", 0);
        if (item.hasCustomBlockData()) {
            for (Tag aTag : item.getCustomBlockData().getAllTags()) {
                nbt.put(aTag.getName(), aTag);
            }
        }

        return BlockEntityHolder.setBlockAndCreateEntity(this, true, true, nbt) != null;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Nonnull
    public Item getFlower() {
        BlockEntityFlowerPot blockEntity = getBlockEntity();
        if (blockEntity == null) {
            return Item.get(ItemID.AIR);
        }
        String id = blockEntity.namedTag.getString("item");

        return Item.get(ItemID.byIdentifier(id), 0, 1);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public boolean setFlower(@Nullable Item item) {
        if (item == null || item.getIdentifier() == ItemID.AIR) {
            removeFlower();
            return true;
        }

        BlockEntityFlowerPot blockEntity = getOrCreateBlockEntity();
        ItemID contentId = item.getIdentifier();
        if (!canPlaceIntoFlowerPot(contentId)) {
            contentId = item.getIdentifier();
            if (!canPlaceIntoFlowerPot(contentId)) {
                return false;
            }
        }

        int itemMeta = item.getDamage();
        blockEntity.namedTag.putString("item", contentId.getIdentifier());
        blockEntity.namedTag.putInt("data", itemMeta);

        setBooleanValue(UPDATE, true);
        getLevel().setBlock(this, this, true);
        blockEntity.spawnToAll();
        return true;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public void removeFlower() {
        BlockEntityFlowerPot blockEntity = getOrCreateBlockEntity();
        blockEntity.namedTag.putShort("item", 0);
        blockEntity.namedTag.putInt("data", 0);

        setBooleanValue(UPDATE, false);
        getLevel().setBlock(this, this, true);
        blockEntity.spawnToAll();
    }

    @Override
    public boolean canBeActivated() {
        return true;
    }

    @Override
    public boolean onActivate(@Nonnull Item item, @Nullable Player player) {
        if (getBooleanValue(UPDATE)) {
            if (player == null) {
                return false;
            }

            Item flower = getFlower();
            if (flower.getIdentifier() != ItemID.AIR) {
                removeFlower();
                player.giveItem(flower);
                return true;
            }
        }

        if (item.isNull()) {
            return false;
        }

        BlockEntityFlowerPot blockEntity = getOrCreateBlockEntity();
        if (blockEntity.namedTag.getShort("item") != 0 || blockEntity.namedTag.getInt("mData") != 0) {
            return false;
        }

        if (!setFlower(item)) {
            return false;
        }

        if (player == null || !player.isCreative()) {
            item.count--;
        }
        return true;
    }

    @Override
    public Item[] getDrops(Item item) {
        boolean dropInside = false;
        BlockID insideID = BlockID.AIR;
        int insideMeta = 0;
        BlockEntityFlowerPot blockEntity = getBlockEntity();
        if (blockEntity != null) {
            dropInside = true;
            insideID = BlockID.byIdentifier(blockEntity.namedTag.getString("item"));
            insideMeta = blockEntity.namedTag.getInt("data");
        }

        if (dropInside) {
            return new Item[]{
                    new ItemFlowerPot(),
                    BlockState.of(insideID, insideMeta).getBlock(this).toItem()
            };
        } else {
            return new Item[]{
                    new ItemFlowerPot()
            };
        }
    }

    @Override
    protected AxisAlignedBB recalculateBoundingBox() {
        return this;
    }

    @Override
    public double getMinX() {
        return this.x + 0.3125;
    }

    @Override
    public double getMinZ() {
        return this.z + 0.3125;
    }

    @Override
    public double getMaxX() {
        return this.x + 0.6875;
    }

    @Override
    public double getMaxY() {
        return this.y + 0.375;
    }

    @Override
    public double getMaxZ() {
        return this.z + 0.6875;
    }

    @Override
    public boolean canPassThrough() {
        return false;
    }

    @Override
    public Item toItem() {
        return new ItemFlowerPot();
    }
}
