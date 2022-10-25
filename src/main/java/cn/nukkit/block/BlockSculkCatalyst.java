package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.BooleanBlockProperty;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockSculkCatalyst extends Block {

    public static final BlockProperties PROPERTIES = new BlockProperties(new BooleanBlockProperty("bloom", false));

    @Override
    public BlockID getId() {
        return BlockID.SCULK_CATALYST;
    }

    @Override
    public String getName() {
        return "Sculk Catalyst";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SCULK_CATALYST);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}