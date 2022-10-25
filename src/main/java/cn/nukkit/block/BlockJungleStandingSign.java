package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemJungleSign;

@PowerNukkitOnly
public class BlockJungleStandingSign extends BlockStandingSign {
    @PowerNukkitOnly
    public BlockJungleStandingSign() {
    }

    @PowerNukkitOnly
    public BlockJungleStandingSign(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.JUNGLE_STANDING_SIGN;
    }

    @PowerNukkitOnly
    @Override
    public BlockID getWallId() {
        return BlockID.JUNGLE_WALL_SIGN;
    }

    @Override
    public String getName() {
        return "Jungle Sign Post";
    }

    @Override
    public Item toItem() {
        return new ItemJungleSign();
    }
}
