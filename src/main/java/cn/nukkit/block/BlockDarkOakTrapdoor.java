package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
public class BlockDarkOakTrapdoor extends BlockTrapdoor {
    @PowerNukkitOnly
    public BlockDarkOakTrapdoor() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockDarkOakTrapdoor(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.DARK_OAK_TRAPDOOR;
    }
    
    @Override
    public String getName() {
        return "Dark Oak Trapdoor";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.BROWN_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DARK_OAK_TRAPDOOR);
    }
}
