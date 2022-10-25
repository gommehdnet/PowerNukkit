package cn.nukkit.level.generator.object.tree;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.item.Item;
import cn.nukkit.level.ChunkManager;
import cn.nukkit.level.Level;
import cn.nukkit.math.BlockVector3;
import cn.nukkit.math.Vector3;

import java.util.Random;

public abstract class TreeGenerator extends cn.nukkit.level.generator.object.BasicGenerator {

    /*
     * returns whether or not a tree can grow into a block
     * For example, a tree will not grow into stone
     */
    protected boolean canGrowInto(BlockID id) {
        return id == BlockID.AIR || id == BlockID.LEAVES || id == BlockID.GRASS || id == BlockID.DIRT || id == BlockID.LOG || id == BlockID.LOG2 || id == BlockID.SAPLING || id == BlockID.VINE;
    }

    public void generateSaplings(Level level, Random random, Vector3 pos) {
    }

    protected void setDirtAt(ChunkManager level, BlockVector3 pos) {
        setDirtAt(level, new Vector3(pos.x, pos.y, pos.z));
    }

    /*
     * sets dirt at a specific location if it isn't already dirt
     */
    protected void setDirtAt(ChunkManager level, Vector3 pos) {
        if (level.getBlockIdAt((int) pos.x, (int) pos.y, (int) pos.z) != BlockID.DIRT) {
            this.setBlockAndNotifyAdequately(level, pos, Block.get(BlockID.DIRT));
        }
    }
}
