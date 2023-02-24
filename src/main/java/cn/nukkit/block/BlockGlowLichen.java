package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.blockproperty.IntBlockProperty;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockGlowLichen extends Block {

    public static final BlockProperties PROPERTIES = new BlockProperties(new IntBlockProperty("multi_face_direction_bits", false, 63, 0));

    @Override
    public BlockID getId() {
        return BlockID.GLOW_LICHEN;
    }

    @Override
    public String getName() {
        return "Glow Lichen";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.GLOW_LICHEN);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    @Override
    public double getHardness() {
        return 0.2;
    }

    @Override
    public double getResistance() {
        return 0.2;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_SHEARS;
    }

    @Override
    public Item[] getDrops(Item item) {
        if (item.isShears()) {
            return new Item[]{this.toItem()};
        }

        return Item.EMPTY_ARRAY;
    }
}