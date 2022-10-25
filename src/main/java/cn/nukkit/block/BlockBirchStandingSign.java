package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemBirchSign;

@PowerNukkitOnly
public class BlockBirchStandingSign extends BlockStandingSign {
    @PowerNukkitOnly
    public BlockBirchStandingSign() {
    }

    @PowerNukkitOnly
    public BlockBirchStandingSign(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.BIRCH_STANDING_SIGN;
    }

    @PowerNukkitOnly
    @Override
    public BlockID getWallId() {
        return BlockID.BIRCH_WALL_SIGN;
    }

    @Override
    public String getName() {
        return "Birch Sign Post";
    }

    @Override
    public Item toItem() {
        return new ItemBirchSign();
    }
}
