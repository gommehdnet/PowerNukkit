package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBirchSign;

@PowerNukkitOnly
public class BlockBirchWallSign extends BlockWallSign {
    @PowerNukkitOnly
    public BlockBirchWallSign() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockBirchWallSign(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.BIRCH_WALL_SIGN;
    }

    @PowerNukkitOnly
    @Override
    protected BlockID getPostId() {
        return BlockID.BIRCH_STANDING_SIGN;
    }

    @Override
    public String getName() {
        return "Birch Wall Sign";
    }

    @Override
    public Item toItem() {
        return new ItemBirchSign();
    }
}
