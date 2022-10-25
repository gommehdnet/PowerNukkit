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
public class BlockSmallAmethystBud extends Block {

    public static final BlockProperties PROPERTIES = new BlockProperties(CommonBlockProperties.FACING_DIRECTION);

    @Override
    public BlockID getId() {
        return BlockID.SMALL_AMETHYST_BUD;
    }

    @Override
    public String getName() {
        return "Small Amethyst Bud";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SMALL_AMETHYST_BUD);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}