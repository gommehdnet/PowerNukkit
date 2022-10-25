package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockSoulLantern extends BlockLantern {

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockSoulLantern() {
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockSoulLantern(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.SOUL_LANTERN;
    }

    @Override
    public String getName() {
        return "Soul Lantern";
    }

    @Override
    public int getLightLevel() {
        return 10;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SOUL_LANTERN);
    }

}
