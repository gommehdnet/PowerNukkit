package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
public class BlockBirchTrapdoor extends BlockTrapdoor {
    @PowerNukkitOnly
    public BlockBirchTrapdoor() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockBirchTrapdoor(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.BIRCH_TRAPDOOR;
    }
    
    @Override
    public String getName() {
        return "Birch Trapdoor";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.SAND_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BIRCH_TRAPDOOR);
    }
}
