package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockSmoker extends BlockLitSmoker {
    @PowerNukkitOnly
    public BlockSmoker() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockSmoker(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Smoker";
    }

    @Override
    public BlockID getId() {
        return BlockID.SMOKER;
    }

    @Override
    public int getLightLevel() {
        return 0;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SMOKER);
    }
}
