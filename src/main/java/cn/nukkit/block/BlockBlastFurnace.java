package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockBlastFurnace extends BlockLitBlastFurnace {
    @PowerNukkitOnly
    public BlockBlastFurnace() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockBlastFurnace(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Blast Furnace";
    }

    @Override
    public BlockID getId() {
        return BlockID.BLAST_FURNACE;
    }

    @Override
    public int getLightLevel() {
        return 0;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BLAST_FURNACE);
    }
}
