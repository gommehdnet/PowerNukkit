package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
public class BlockAcaciaTrapdoor extends BlockTrapdoor {
    @PowerNukkitOnly
    public BlockAcaciaTrapdoor() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockAcaciaTrapdoor(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.ACACIA_TRAPDOOR;
    }
    
    @Override
    public String getName() {
        return "Acacia Trapdoor";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.ORANGE_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.ACACIA_TRAPDOOR);
    }
}
