package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.blockproperty.value.SmallFlowerType;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author xtypr
 * @since 2015/12/2
 */
public class BlockYellowFlower extends BlockRedFlower {
    public BlockYellowFlower() {
        this(0);
    }

    public BlockYellowFlower(int meta) {
        super(0);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return CommonBlockProperties.EMPTY_PROPERTIES;
    }

    @Override
    public BlockID getId() {
        return BlockID.YELLOW_FLOWER;
    }

    @Override
    protected Block getUncommonFlower() {
        return get(BlockID.RED_FLOWER);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public void setFlowerType(SmallFlowerType flowerType) {
        setOnSingleFlowerType(SmallFlowerType.DANDELION, flowerType);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public SmallFlowerType getFlowerType() {
        return SmallFlowerType.DANDELION;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.YELLOW_FLOWER);
    }
}
