package cn.nukkit.level.generator.populator.helper;

import cn.nukkit.block.BlockID;
import cn.nukkit.level.format.FullChunk;

import java.util.HashSet;
import java.util.Set;

/**
 * @author DaPorkchop_
 */
public final class PopulatorHelpers {
    private static final Set<BlockID> nonSolidBlocks = new HashSet<>();

    static {
        nonSolidBlocks.add(BlockID.AIR);
        nonSolidBlocks.add(BlockID.LEAVES);
        nonSolidBlocks.add(BlockID.LEAVES2);
        nonSolidBlocks.add(BlockID.SNOW_LAYER);
    }

    private PopulatorHelpers() {
    }

    public static boolean canGrassStay(int x, int y, int z, FullChunk chunk) {
        return EnsureCover.ensureCover(x, y, z, chunk) && EnsureGrassBelow.ensureGrassBelow(x, y, z, chunk);
    }

    public static boolean isNonSolid(BlockID id)   {
        return nonSolidBlocks.contains(id);
    }
}
