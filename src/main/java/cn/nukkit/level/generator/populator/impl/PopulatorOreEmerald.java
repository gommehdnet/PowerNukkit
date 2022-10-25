package cn.nukkit.level.generator.populator.impl;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.BlockID;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.level.ChunkManager;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.level.generator.populator.type.Populator;
import cn.nukkit.math.NukkitMath;
import cn.nukkit.math.NukkitRandom;

/**
 * @author GoodLucky777
 */
@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class PopulatorOreEmerald extends Populator {

    private static final BlockState STATE_STONE = BlockState.of(BlockID.STONE);
    private static final BlockState STATE_EMERALD_ORE = BlockState.of(BlockID.EMERALD_ORE);

    @PowerNukkitOnly
    public PopulatorOreEmerald() {
        super();
    }

    @Override
    public void populate(ChunkManager level, int chunkX, int chunkZ, NukkitRandom random, FullChunk chunk) {
        for (int i = 0; i < 11; i++) {
            int x = random.nextBoundedInt(16);
            int z = random.nextBoundedInt(16);
            int y = NukkitMath.randomRange(random, 0, 32);
            
            if (chunk.getBlockState(x, y, z) != STATE_STONE) {
                continue;
            }
            chunk.setBlockState(x, y, z, STATE_EMERALD_ORE);
        }
    }
}
