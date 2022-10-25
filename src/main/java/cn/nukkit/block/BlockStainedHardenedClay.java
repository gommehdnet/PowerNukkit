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
public class BlockStainedHardenedClay extends Block {

    public static final BlockProperties PROPERTIES = CommonBlockProperties.COLOR_BLOCK_PROPERTIES;

    @Override
    public BlockID getId() {
        return BlockID.STAINED_HARDENED_CLAY;
    }

    @Override
    public String getName() {
        return "Stained Hardened Clay";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.STAINED_HARDENED_CLAY, this.getDamage());
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}