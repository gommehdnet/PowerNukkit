package cn.nukkit.level.generator.object.tree;

import cn.nukkit.api.DeprecationDetails;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.block.BlockSapling;
import cn.nukkit.blockproperty.value.WoodType;
import cn.nukkit.blockstate.BlockState;
import cn.nukkit.level.ChunkManager;
import cn.nukkit.math.NukkitRandom;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public abstract class ObjectTree {
    protected boolean overridable(BlockID id) {
        return id.equals(BlockID.AIR) || id.equals(BlockID.SAPLING) || id.equals(BlockID.LOG) ||
                id.equals(BlockID.LEAVES) || id.equals(BlockID.SNOW_LAYER) || id.equals(BlockID.LOG2) || id.equals(BlockID.LEAVES2);
    }

    public int getType() {
        return 0;
    }

    public BlockID getTrunkBlock() {
        return BlockID.LOG;
    }

    public BlockID getLeafBlock() {
        return BlockID.LEAVES;
    }

    public int getTreeHeight() {
        return 7;
    }

    public static void growTree(ChunkManager level, int x, int y, int z, NukkitRandom random) {
        growTree(level, x, y, z, random, 0);
    }

    @Deprecated
    @DeprecationDetails(since = "1.4.0.0-PN", by = "PowerNukkit", reason = "Magic value in type",
            replaceWith = "growTree(ChunkManager level, int x, int y, int z, NukkitRandom random, WoodType type, boolean tall)")
    public static void growTree(ChunkManager level, int x, int y, int z, NukkitRandom random, int type) {
        WoodType woodType;
        boolean tall = false;
        switch (type) {
            case BlockSapling.SPRUCE:
                woodType = WoodType.SPRUCE;
                break;
            case BlockSapling.BIRCH:
                woodType = WoodType.BIRCH;
                break;
            case BlockSapling.JUNGLE:
                woodType = WoodType.JUNGLE;
                break;
            case BlockSapling.BIRCH_TALL:
                woodType = WoodType.BIRCH;
                tall = true;
                break;
            case BlockSapling.OAK:
            default:
                woodType = WoodType.OAK;
                break;
        }

        growTree(level, x, y, z, random, woodType, tall);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static void growTree(ChunkManager level, int x, int y, int z, NukkitRandom random, WoodType type, boolean tall) {
        ObjectTree tree;
        switch (type) {
            case SPRUCE:
                tree = new ObjectSpruceTree();
                break;
            case BIRCH:
                if (tall) {
                    tree = new ObjectTallBirchTree();
                } else {
                    tree = new ObjectBirchTree();
                }
                break;
            case JUNGLE:
                tree = new ObjectJungleTree();
                break;
            case OAK:
            default:
                tree = new ObjectOakTree();
                //todo: more complex treeeeeeeeeeeeeeeee
                break;
        }

        if (tree.canPlaceObject(level, x, y, z, random)) {
            tree.placeObject(level, x, y, z, random);
        }
    }


    public boolean canPlaceObject(ChunkManager level, int x, int y, int z, NukkitRandom random) {
        int radiusToCheck = 0;
        for (int yy = 0; yy < this.getTreeHeight() + 3; ++yy) {
            if (yy == 1 || yy == this.getTreeHeight()) {
                ++radiusToCheck;
            }
            for (int xx = -radiusToCheck; xx < (radiusToCheck + 1); ++xx) {
                for (int zz = -radiusToCheck; zz < (radiusToCheck + 1); ++zz) {
                    if (!this.overridable(level.getBlockIdAt(x + xx, y + yy, z + zz))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public void placeObject(ChunkManager level, int x, int y, int z, NukkitRandom random) {

        this.placeTrunk(level, x, y, z, random, this.getTreeHeight() - 1);

        for (int yy = y - 3 + this.getTreeHeight(); yy <= y + this.getTreeHeight(); ++yy) {
            double yOff = yy - (y + this.getTreeHeight());
            int mid = (int) (1 - yOff / 2);
            for (int xx = x - mid; xx <= x + mid; ++xx) {
                int xOff = Math.abs(xx - x);
                for (int zz = z - mid; zz <= z + mid; ++zz) {
                    int zOff = Math.abs(zz - z);
                    if (xOff == mid && zOff == mid && (yOff == 0 || random.nextBoundedInt(2) == 0)) {
                        continue;
                    }
                    if (!Block.isSolid(level.getBlockIdAt(xx, yy, zz))) {
                        level.setBlockStateAt(xx, yy, zz, BlockState.of(this.getLeafBlock(), this.getType()));
                    }
                }
            }
        }
    }

    protected void placeTrunk(ChunkManager level, int x, int y, int z, NukkitRandom random, int trunkHeight) {
        // The base dirt block
        level.setBlockAt(x, y - 1, z, BlockID.DIRT);

        for (int yy = 0; yy < trunkHeight; ++yy) {
            BlockID blockId = level.getBlockIdAt(x, y + yy, z);
            if (this.overridable(blockId)) {
                level.setBlockStateAt(x, y + yy, z, BlockState.of(this.getTrunkBlock(), this.getType()));
            }
        }
    }
}
