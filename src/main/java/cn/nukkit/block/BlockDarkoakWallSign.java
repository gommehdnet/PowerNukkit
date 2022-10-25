package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemDarkOakSign;

@PowerNukkitOnly
public class BlockDarkoakWallSign extends BlockWallSign {
    @PowerNukkitOnly
    public BlockDarkoakWallSign() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockDarkoakWallSign(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.DARKOAK_WALL_SIGN;
    }

    @PowerNukkitOnly
    @Override
    protected BlockID getPostId() {
        return BlockID.DARKOAK_STANDING_SIGN;
    }

    @Override
    public String getName() {
        return "Dark Oak Wall Sign";
    }

    @Override
    public Item toItem() {
        return new ItemDarkOakSign();
    }
}
