package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
public class BlockSpruceTrapdoor extends BlockTrapdoor {
    @PowerNukkitOnly
    public BlockSpruceTrapdoor() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockSpruceTrapdoor(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.SPRUCE_TRAPDOOR;
    }
    
    @Override
    public String getName() {
        return "Spruce Trapdoor";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.SPRUCE_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SPRUCE_TRAPDOOR);
    }
}
