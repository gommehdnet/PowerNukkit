package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockMudBrickDoubleSlab extends BlockDoubleSlabBase {

    public BlockMudBrickDoubleSlab(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.MUD_BRICK_DOUBLE_SLAB;
    }

    @Override
    public String getName() {
        return "Mud Brick Double Slab";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public String getSlabName() {
        return "Mud Brick";
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public BlockID getSingleSlabId() {
        return BlockID.MUD_BRICK_SLAB;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.MUD_BRICK_DOUBLE_SLAB);
    }
}