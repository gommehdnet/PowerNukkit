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
public class BlockHardStainedGlass extends BlockTransparent {

    public static final BlockProperties PROPERTIES = CommonBlockProperties.COLOR_BLOCK_PROPERTIES;

    @Override
    public BlockID getId() {
        return BlockID.HARD_STAINED_GLASS;
    }

    @Override
    public String getName() {
        return "Hard Stained Glass";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.HARD_STAINED_GLASS);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}