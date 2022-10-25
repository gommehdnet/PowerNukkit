package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockSoulTorch extends BlockTorch {

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockSoulTorch() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockSoulTorch(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Soul Torch";
    }

    @Override
    public BlockID getId() {
        return BlockID.SOUL_TORCH;
    }

    @Override
    public int getLightLevel() {
        return 10;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SOUL_TORCH);
    }
}
