package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemAcaciaSign;

@PowerNukkitOnly
public class BlockAcaciaStandingSign extends BlockStandingSign {
    @PowerNukkitOnly
    public BlockAcaciaStandingSign() {
    }

    @PowerNukkitOnly
    public BlockAcaciaStandingSign(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.ACACIA_STANDING_SIGN;
    }

    @PowerNukkitOnly
    @Override
    public BlockID getWallId() {
        return BlockID.ACACIA_WALL_SIGN;
    }

    @Override
    public String getName() {
        return "Acacia Sign Post";
    }

    @Override
    public Item toItem() {
        return new ItemAcaciaSign();
    }
}
