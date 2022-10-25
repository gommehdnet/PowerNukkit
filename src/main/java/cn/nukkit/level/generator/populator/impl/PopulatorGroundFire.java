package cn.nukkit.level.generator.populator.impl;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.level.ChunkManager;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.level.generator.populator.helper.EnsureBelow;
import cn.nukkit.level.generator.populator.helper.EnsureCover;
import cn.nukkit.level.generator.populator.type.PopulatorSurfaceBlock;
import cn.nukkit.math.NukkitRandom;

/**
 * @author DaPorkchop_
 */
public class PopulatorGroundFire extends PopulatorSurfaceBlock {
    @Override
    protected boolean canStay(int x, int y, int z, FullChunk chunk) {
        return EnsureCover.ensureCover(x, y, z, chunk) && EnsureBelow.ensureBelow(x, y, z, BlockID.NETHERRACK, chunk);
    }

    @Override
    protected BlockID getBlockId(int x, int z, NukkitRandom random, FullChunk chunk) {
        return BlockID.FIRE;
    }

    @Override
    protected void placeBlock(int x, int y, int z, BlockID id, FullChunk chunk, NukkitRandom random) {
        super.placeBlock(x, y, z, id, chunk, random);
        chunk.setBlockLight(x, y, z, Block.getLightLevel(BlockID.FIRE));
    }

    @Override
    protected int getHighestWorkableBlock(ChunkManager level, int x, int z, FullChunk chunk) {
        int y;
        for (y = 0; y <= 127; ++y) {
            BlockID b = chunk.getBlockId(x, y, z);
            if (b == BlockID.AIR) {
                break;
            }
        }
        return y == 0 ? -1 : y;
    }
}
