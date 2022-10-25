package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDeepslateTileDoubleSlab extends BlockDoubleSlabBase {

    public BlockDeepslateTileDoubleSlab(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.DEEPSLATE_TILE_DOUBLE_SLAB;
    }

    @Override
    public String getName() {
        return "Deepslate Tile Double Slab";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public String getSlabName() {
        return "Deepslate Tile";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public BlockID getSingleSlabId() {
        return BlockID.DEEPSLATE_TILE_SLAB;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DEEPSLATE_TILE_DOUBLE_SLAB);
    }
}