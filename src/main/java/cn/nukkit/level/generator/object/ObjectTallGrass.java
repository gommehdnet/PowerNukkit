package cn.nukkit.level.generator.object;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.level.ChunkManager;
import cn.nukkit.math.NukkitRandom;
import cn.nukkit.math.Vector3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ItsLucas (Nukkit Project)
 */
public class ObjectTallGrass {
    public static void growGrass(ChunkManager level, Vector3 pos, NukkitRandom random) {
        for (int i = 0; i < 128; ++i) {
            int num = 0;

            int x = pos.getFloorX();
            int y = pos.getFloorY() + 1;
            int z = pos.getFloorZ();

            while (true) {
                if (num >= i / 16) {
                    if (level.getBlockIdAt(x, y, z) == BlockID.AIR) {
                        if (random.nextBoundedInt(8) == 0) {
                            //porktodo: biomes have specific flower types that can grow in them
                            if (random.nextBoolean()) {
                                level.setBlockAt(x, y, z, BlockID.YELLOW_FLOWER);
                            } else {
                                level.setBlockAt(x, y, z, BlockID.RED_FLOWER);
                            }
                        } else {
                            level.setBlockAt(x, y, z, BlockID.TALLGRASS);
                        }
                    }

                    break;
                }

                x += random.nextRange(-1, 1);
                y += random.nextRange(-1, 1) * random.nextBoundedInt(3) / 2;
                z += random.nextRange(-1, 1);

                if (level.getBlockIdAt(x, y - 1, z) != BlockID.GRASS || y > 255 || y < 0) {
                    break;
                }

                ++num;
            }
        }
    }

    @PowerNukkitOnly
    public static void growGrass(ChunkManager level, Vector3 pos, NukkitRandom random, int count, int radius) {
        String[][] arr = {
                {BlockID.YELLOW_FLOWER.getIdentifier(), "0"},
                {BlockID.RED_FLOWER.getIdentifier(), "0"},
                {BlockID.TALLGRASS.getIdentifier(), "1"},
                {BlockID.TALLGRASS.getIdentifier(), "1"},
                {BlockID.TALLGRASS.getIdentifier(), "1"},
                {BlockID.TALLGRASS.getIdentifier(), "1"}
        };
        int arrC = arr.length - 1;
        for (int c = 0; c < count; c++) {
            int x = random.nextRange((int) (pos.x - radius), (int) (pos.x + radius));
            int z = random.nextRange((int) (pos.z) - radius, (int) (pos.z + radius));

            if (level.getBlockIdAt(x, (int) (pos.y + 1), z) == BlockID.AIR && level.getBlockIdAt(x, (int) (pos.y), z) == BlockID.GRASS) {
                String[] t = arr[random.nextRange(0, arrC)];
                level.setBlockAt(x, (int) (pos.y + 1), z, BlockID.byIdentifier(t[0]));
            }
        }
    }
}
