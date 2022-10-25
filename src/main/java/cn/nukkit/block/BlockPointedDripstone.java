package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.*;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockPointedDripstone extends Block {

    public static final BlockProperties PROPERTIES = new BlockProperties(new ArrayBlockProperty<>("dripstone_thickness", true, DripstoneThickness.values()),
            new BooleanBlockProperty("hanging", false));

    @Override
    public BlockID getId() {
        return BlockID.POINTED_DRIPSTONE;
    }

    @Override
    public String getName() {
        return "Pointed Dripstone";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.POINTED_DRIPSTONE);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    public enum DripstoneThickness {
        TIP,
        FRUSTUM,
        MIDDLE,
        BASE,
        MERGE
    }
}