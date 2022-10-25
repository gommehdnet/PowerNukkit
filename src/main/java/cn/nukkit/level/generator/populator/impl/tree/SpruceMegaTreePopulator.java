package cn.nukkit.level.generator.populator.impl.tree;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.block.BlockSapling;
import cn.nukkit.level.ChunkManager;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.level.generator.object.tree.ObjectBigSpruceTree;
import cn.nukkit.level.generator.populator.type.Populator;
import cn.nukkit.math.NukkitMath;
import cn.nukkit.math.NukkitRandom;
import cn.nukkit.math.Vector3;

/**
 * @author DaPorkchop_
 */
public class SpruceMegaTreePopulator extends Populator {
    private ChunkManager level;
    private int randomAmount;
    private int baseAmount;

    private final int type;

    public SpruceMegaTreePopulator() {
        this(BlockSapling.SPRUCE);
    }

    private SpruceMegaTreePopulator(int type) {
        this.type = type;
    }

    public void setRandomAmount(int randomAmount) {
        this.randomAmount = randomAmount;
    }

    public void setBaseAmount(int baseAmount) {
        this.baseAmount = baseAmount;
    }

    @Override
    public void populate(ChunkManager level, int chunkX, int chunkZ, NukkitRandom random, FullChunk chunk) {
        this.level = level;
        int amount = random.nextBoundedInt(this.randomAmount + 1) + this.baseAmount;
        Vector3 v = new Vector3();

        for (int i = 0; i < amount; ++i) {
            int x = NukkitMath.randomRange(random, chunkX << 4, (chunkX << 4) + 15);
            int z = NukkitMath.randomRange(random, chunkZ << 4, (chunkZ << 4) + 15);
            int y = this.getHighestWorkableBlock(x, z);
            if (y == -1) {
                continue;
            }
            new ObjectBigSpruceTree(1 / 4f, 5).placeObject(this.level, (int) (v.x = x), (int) (v.y = y), (int) (v.z = z), random);
        }
    }

    private int getHighestWorkableBlock(int x, int z) {
        int y;
        for (y = 255; y > 0; --y) {
            BlockID b = this.level.getBlockIdAt(x, y, z);
            if (b == BlockID.DIRT || b == BlockID.GRASS) {
                break;
            } else if (b != BlockID.AIR && b != BlockID.SNOW_LAYER) {
                return -1;
            }
        }

        return ++y;
    }
}
