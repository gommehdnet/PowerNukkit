package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.value.WoodType;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockAzaleaLeaves extends BlockLeaves {

    public static final BlockProperties PROPERTIES = new BlockProperties(BlockLeaves.PERSISTENT, BlockLeaves.UPDATE);

    @Override
    public BlockID getId() {
        return BlockID.AZALEA_LEAVES;
    }

    @Override
    public String getName() {
        return "Azalea Leaves";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.AZALEA_LEAVES);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    public WoodType getWoodType() {
        return WoodType.OAK;
    }
}