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
public class BlockLightBlueCandleCake extends BlockCandle {

    public static BlockProperties PROPERTIES = new BlockProperties(new BooleanBlockProperty("lit", false));

    @Override
    public BlockID getId() {
        return BlockID.LIGHT_BLUE_CANDLE_CAKE;
    }

    @Override
    public String getName() {
        return "Light Blue Candle Cake";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.LIGHT_BLUE_CANDLE_CAKE);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}