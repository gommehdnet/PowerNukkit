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
public class BlockRedCandleCake extends Block {

    public static BlockProperties PROPERTIES = new BlockProperties(new BooleanBlockProperty("lit", false));

    @Override
    public BlockID getId() {
        return BlockID.RED_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Red Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.RED_CANDLE_CAKE);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}