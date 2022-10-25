package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateBrickDoubleSlab extends BlockDoubleSlabBase {

    public BlockDeepslateBrickDoubleSlab(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_BRICK_DOUBLE_SLAB;
    }

    @Override
    public String getName() {
        return "Deepslate Brick Double Slab";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public String getSlabName() {
        return "Deepslate Brick";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public BlockID getSingleSlabId() {
        return BlockID.DEEPSLATE_BRICK_SLAB;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_BRICK_DOUBLE_SLAB);
    }
}