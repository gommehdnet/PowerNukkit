package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMangroveDoubleSlab extends BlockDoubleSlabBase {

    public BlockMangroveDoubleSlab(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.MANGROVE_DOUBLE_SLAB;
    }

    @Override
    public String getName() {
        return "Mangrove Double Slab";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public String getSlabName() {
        return "Mangrove";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public BlockID getSingleSlabId() {
        return BlockID.MANGROVE_SLAB;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MANGROVE_DOUBLE_SLAB);
    }
}