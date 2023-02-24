package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.IntBlockProperty;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;

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

    @Override
    public int getLightLevel() {
        return 14;
    }

    @Override
    public int getBurnChance() {
        return 15;
    }

    @Override
    public int getBurnAbility() {
        return 60;
    }

    @Override
    public Item[] getDrops(Item item) {
        if (item.isTool() && item.hasEnchantment(Enchantment.ID_SILK_TOUCH)) {
            return new Item[]{Item.get(ItemID.GLOW_BERRIES)};
        }

        return Item.EMPTY_ARRAY;
    }
}