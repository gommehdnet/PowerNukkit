package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.ArrayBlockProperty;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.BooleanBlockProperty;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockColoredTorchBp extends Block {

    public static final BlockProperties PROPERTIES = new BlockProperties(new BooleanBlockProperty("color_bit", true),
            new ArrayBlockProperty<>("torch_facing_direction", false, new String[]{"unknown", "west", "east", "north", "south", "top"}));

    @Override
    public BlockID getId() {
        return BlockID.COLORED_TORCH_BP;
    }

    @Override
    public String getName() {
        return "Colored Torch Bp";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.COLORED_TORCH_BP);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}