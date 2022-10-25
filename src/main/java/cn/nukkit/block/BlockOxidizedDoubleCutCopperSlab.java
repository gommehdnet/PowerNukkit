package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockOxidizedDoubleCutCopperSlab extends BlockDoubleSlabBase {

    public BlockOxidizedDoubleCutCopperSlab(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.OXIDIZED_DOUBLE_CUT_COPPER_SLAB;
    }

    @Override
    public String getName() {
        return "Oxidized Double Cut Copper Slab";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public String getSlabName() {
        return "Oxidized Cut Copper";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public BlockID getSingleSlabId() {
        return BlockID.OXIDIZED_CUT_COPPER_SLAB;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.OXIDIZED_DOUBLE_CUT_COPPER_SLAB);
    }
}