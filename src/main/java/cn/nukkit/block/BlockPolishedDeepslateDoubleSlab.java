package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockPolishedDeepslateDoubleSlab extends BlockDoubleSlabBase {

    public BlockPolishedDeepslateDoubleSlab(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.POLISHED_DEEPSLATE_DOUBLE_SLAB;
    }

    @Override
    public String getName() {
        return "Polished Deepslate Double Slab";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public String getSlabName() {
        return "Polished Deepslate";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public BlockID getSingleSlabId() {
        return BlockID.POLISHED_DEEPSLATE_SLAB;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.POLISHED_DEEPSLATE_DOUBLE_SLAB);
    }
}