package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemSpruceSign;

@PowerNukkitOnly
public class BlockSpruceWallSign extends BlockWallSign {
    @PowerNukkitOnly
    public BlockSpruceWallSign() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockSpruceWallSign(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.SPRUCE_WALL_SIGN;
    }

    @PowerNukkitOnly
    @Override
    protected BlockID getPostId() {
        return BlockID.SPRUCE_STANDING_SIGN;
    }

    @Override
    public String getName() {
        return "Spruce Wall Sign";
    }

    @Override
    public Item toItem() {
        return new ItemSpruceSign();
    }
}
