package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.ArrayBlockProperty;
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
public class BlockBigDripleaf extends Block {

    public static final BlockProperties PROPERTIES = new BlockProperties(new BooleanBlockProperty("big_dripleaf_head", false),
            new ArrayBlockProperty<>("big_dripleaf_tilt", false, BigDripleafTilt.values()), CommonBlockProperties.DIRECTION);

    @Override
    public BlockID getId() {
        return BlockID.BIG_DRIPLEAF;
    }

    @Override
    public String getName() {
        return "Big Dripleaf";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BIG_DRIPLEAF);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    public enum BigDripleafTilt {
        NONE,
        UNSTABLE,
        PARTIAL_TILT,
        FULL_TILT
    }
}