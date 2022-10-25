package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

import javax.annotation.Nullable;

@Since("1.4.0.0-PN")
@PowerNukkitOnly
public class BlockCrimsonFungus extends BlockFungus {

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public BlockCrimsonFungus() {
        // Does nothing
    }

    @Override
    public BlockID getId() {
        return BlockID.CRIMSON_FUNGUS;
    }

    @Override
    public String getName() {
        return "Crimson Fungus";
    }

    @PowerNukkitOnly
    @Override
    protected boolean canGrowOn(Block support) {
        return support.getId() == BlockID.CRIMSON_NYLIUM;
    }

    @PowerNukkitOnly
    @Override
    public boolean grow(@Nullable Player cause) {
        // TODO Make it grow
        return false;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.NETHERRACK_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CRIMSON_FUNGUS);
    }
}
