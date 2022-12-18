package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.IntBlockProperty;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCaveVines extends Block {

    public static BlockProperties PROPERTIES = new BlockProperties(new IntBlockProperty("growing_plant_age", false, 25));

    @Override
    public BlockID getId() {
        return BlockID.CAVE_VINES;
    }

    @Override
    public String getName() {
        return "Cave Vines";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CAVE_VINES);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}