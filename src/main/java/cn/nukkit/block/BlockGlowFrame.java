package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.BooleanBlockProperty;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockGlowFrame extends Block {

    public static final BlockProperties PROPERTIES = new BlockProperties(CommonBlockProperties.FACING_DIRECTION,
            new BooleanBlockProperty("item_frame_map_bit", false),
            new BooleanBlockProperty("item_frame_photo_bit", false));

    @Override
    public BlockID getId() {
        return BlockID.GLOW_FRAME;
    }

    @Override
    public String getName() {
        return "Glow Frame";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.GLOW_FRAME);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}