package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.ArrayBlockProperty;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockUnderwaterTorch extends Block {

    public static BlockProperties PROPERTIES = new BlockProperties(new ArrayBlockProperty<>("torch_facing_direction", false, new String[]{"unknown", "west", "east", "north", "south", "top"}));

    @Override
    public BlockID getId() {
        return BlockID.UNDERWATER_TORCH;
    }

    @Override
    public String getName() {
        return "Underwater Torch";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.UNDERWATER_TORCH);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}