package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.ArrayBlockProperty;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.BlockProperty;
import cn.nukkit.blockproperty.BooleanBlockProperty;
import cn.nukkit.blockproperty.value.WoodType;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.blockstate.IBlockState;
import cn.nukkit.blockstate.exception.InvalidBlockStateException;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

import javax.annotation.Nonnull;

import static cn.nukkit.blockproperty.CommonBlockProperties.PILLAR_AXIS;

/**
 * @author MagicDroidX (Nukkit Project)
 */
@PowerNukkitDifference(info = "Extends BlockLog instead of BlockSolidMeta only in PowerNukkit", since = "1.4.0.0-PN")
public class BlockWood extends BlockLogAbstract {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static final BlockProperty<WoodType> OLD_LOG_TYPE = new ArrayBlockProperty<>("old_log_type", true, new WoodType[]{
            WoodType.OAK, WoodType.SPRUCE, WoodType.BIRCH, WoodType.JUNGLE
    });

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static final BlockProperties PROPERTIES = new BlockProperties(new BooleanBlockProperty("stripped_bit", true),
            new ArrayBlockProperty<>("wood_type", true, WoodType.values()), PILLAR_AXIS);

    public static final int OAK = 0;
    public static final int SPRUCE = 1;
    public static final int BIRCH = 2;
    public static final int JUNGLE = 3;


    public BlockWood() {
        this(0);
    }

    public BlockWood(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.WOOD;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    @Override
    public double getHardness() {
        return 2;
    }

    @Override
    public double getResistance() {
        return 2;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public WoodType getWoodType() {
        return getPropertyValue(OLD_LOG_TYPE);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public void setWoodType(WoodType woodType) {
        setPropertyValue(OLD_LOG_TYPE, woodType);
    }

    @Override
    public String getName() {
        return getWoodType().getEnglishName() + " Log";
    }

    @Since("1.5.1.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public Block forState(@Nonnull IBlockState state) throws InvalidBlockStateException {
        BlockID id = getId();
        if (id != BlockID.LOG && id != BlockID.LOG2) {
            return super.forState(state);
        }

        id = state.getBlockId();
        if (id != BlockID.LOG && id != BlockID.LOG2 || state.getBitSize() != 4) {
            return super.forState(state);
        }

        int exactInt = state.getExactIntStorage();
        if ((exactInt & 0b1100) == 0b1100) {
            int increment = state.getBlockId() == BlockID.LOG ? 0b000 : 0b100;
            return BlockState.of(BlockID.LOG, (exactInt & 0b11) + increment).getBlock(this, layer);
        }

        return super.forState(state);
    }

    @Override
    public int getBurnChance() {
        return 5;
    }

    @Override
    public int getBurnAbility() {
        return 10;
    }

    @PowerNukkitOnly
    @Override
    protected BlockState getStrippedState() {
        BlockID strippedId;
        switch (getWoodType()) {
            default:
            case OAK:
                strippedId = BlockID.STRIPPED_OAK_LOG;
                break;
            case SPRUCE:
                strippedId = BlockID.STRIPPED_SPRUCE_LOG;
                break;
            case BIRCH:
                strippedId = BlockID.STRIPPED_BIRCH_LOG;
                break;
            case JUNGLE:
                strippedId = BlockID.STRIPPED_JUNGLE_LOG;
                break;
            case ACACIA:
                strippedId = BlockID.STRIPPED_ACACIA_LOG;
                break;
            case DARK_OAK:
                strippedId = BlockID.STRIPPED_DARK_OAK_LOG;
                break;
        }
        return BlockState.of(strippedId).withProperty(PILLAR_AXIS, getPillarAxis());
    }

    @Override
    public BlockColor getColor() {
        return getWoodType().getColor();
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WOOD, this.getDamage());
    }
}
