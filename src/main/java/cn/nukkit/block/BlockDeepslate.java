package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.item.enchantment.Enchantment;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslate extends Block {

    public static BlockProperties PROPERTIES = new BlockProperties(CommonBlockProperties.PILLAR_AXIS);

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE;
    }

    @Override
    public String getName() {
        return "Deepslate";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public Item[] getDrops(Item item) {
        return new Item[]{Item.get(ItemID.COBBLED_DEEPSLATE)};
    }

    @Override
    public boolean canSilkTouch() {
        return true;
    }

    @Override
    public double getHardness() {
        return 3;
    }

    @Override
    public double getResistance() {
        return 6;
    }
}