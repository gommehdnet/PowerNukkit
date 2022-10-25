package cn.nukkit.level.biome.type;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.BlockID;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public abstract class SandyBiome extends CoveredBiome {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public int getSurfaceDepth(int y) {
        if (useNewRakNetSurfaceDepth()) {
            return getSurfaceDepth(0,y,0);
        }
        return 3;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public BlockID getSurfaceBlock(int y) {
        if (useNewRakNetSurface()) {
            return getSurfaceId(0,y,0);
        }
        return BlockID.SAND;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public int getGroundDepth(int y) {
        if (useNewRakNetGroundDepth()) {
            return getGroundDepth(0, y, 0);
        }
        return 2;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public BlockID getGroundBlock(int y) {
        if (useNewRakNetGround()) {
            return getGroundId(0, y, 0);
        }
        return BlockID.SANDSTONE;
    }
}
