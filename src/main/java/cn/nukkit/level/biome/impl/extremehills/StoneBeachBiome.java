package cn.nukkit.level.biome.impl.extremehills;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.BlockID;
import cn.nukkit.level.biome.type.CoveredBiome;

/**
 * @author DaPorkchop_
 * <p>
 * Occurs when Extreme hills and variants touch the ocean.
 *
 * Nearly ertical cliffs, but no overhangs. Height difference is 2-7 near ocean, and pretty much flat everywhere else
 */
public class StoneBeachBiome extends CoveredBiome {
    public StoneBeachBiome() {
        this.setBaseHeight(0.1f);
        this.setHeightVariation(0.8f);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public int getSurfaceDepth(int y) {
        if (useNewRakNetSurfaceDepth()) {
            return getSurfaceDepth(0,y,0);
        }
        return 0;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public BlockID getSurfaceBlock(int y) {
        if (useNewRakNetSurface()) {
            return getSurfaceId(0,y,0);
        }
        return BlockID.AIR;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public int getGroundDepth(int y) {
        if (useNewRakNetGroundDepth()) {
            return getGroundDepth(0,y,0);
        }
        return 0;
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    @Override
    public BlockID getGroundBlock(int y) {
        if (useNewRakNetGround()) {
            return getGroundId(0,y,0);
        }
        return BlockID.AIR;
    }

    @Override
    public String getName() {
        return "Stone Beach";
    }
}
