package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
public class BlockJungleTrapdoor extends BlockTrapdoor {
    @PowerNukkitOnly
    public BlockJungleTrapdoor() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockJungleTrapdoor(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.JUNGLE_TRAPDOOR;
    }
    
    @Override
    public String getName() {
        return "Jungle Trapdoor";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.DIRT_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.JUNGLE_TRAPDOOR);
    }
}
