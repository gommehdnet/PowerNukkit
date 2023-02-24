package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockTintedGlass extends Block {

    @Override
    public BlockID getId() {
        return BlockID.TINTED_GLASS;
    }

    @Override
    public String getName() {
        return "Tinted Glass";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.TINTED_GLASS);
    }

    @Override
    public double getHardness() {
        return 0.3;
    }

    @Override
    public double getResistance() {
        return 0.3;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getLightFilter() {
        return 15;
    }
}