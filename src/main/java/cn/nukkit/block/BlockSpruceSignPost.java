package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemSpruceSign;

@PowerNukkitOnly
public class BlockSpruceSignPost extends BlockStandingSign {
    @PowerNukkitOnly
    public BlockSpruceSignPost() {
    }

    @PowerNukkitOnly
    public BlockSpruceSignPost(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.SPRUCE_STANDING_SIGN;
    }

    @PowerNukkitOnly
    @Override
    public BlockID getWallId() {
        return BlockID.SPRUCE_WALL_SIGN;
    }

    @Override
    public String getName() {
        return "Spruce Sign Post";
    }

    @Override
    public Item toItem() {
        return new ItemSpruceSign();
    }
}
