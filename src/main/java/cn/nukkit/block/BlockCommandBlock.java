package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.BooleanBlockProperty;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.blockproperty.IntBlockProperty;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCommandBlock extends Block {

    public static BlockProperties PROPERTIES = new BlockProperties(new BooleanBlockProperty("conditional_bit", false), CommonBlockProperties.FACING_DIRECTION);

    @Override
    public BlockID getId() {
        return BlockID.COMMAND_BLOCK;
    }

    @Override
    public String getName() {
        return "Command Block";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.COMMAND_BLOCK);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}