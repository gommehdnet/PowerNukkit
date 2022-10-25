package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockSmallDripleafBlock extends Block {

    public static final BlockProperties PROPERTIES = new BlockProperties(CommonBlockProperties.DIRECTION, CommonBlockProperties.UPPER_BLOCK);

    @Override
    public BlockID getId() {
        return BlockID.SMALL_DRIPLEAF_BLOCK;
    }

    @Override
    public String getName() {
        return "Small Dripleaf Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SMALL_DRIPLEAF_BLOCK);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}