package cn.nukkit.block;

import cn.nukkit.level.Level;

/**
 * @author Angelic47 (Nukkit Project)
 */
public class BlockLava extends BlockFlowingLava {

    public BlockLava() {
        super(0);
    }

    public BlockLava(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.LAVA;
    }

    @Override
    public String getName() {
        return "Still Lava";
    }

    @Override
    public BlockLiquid getBlock(int meta) {
        return (BlockLiquid) Block.get(BlockID.LAVA, meta);
    }

    @Override
    public int onUpdate(int type) {
        if (type != Level.BLOCK_UPDATE_SCHEDULED) {
            return super.onUpdate(type);
        }
        return 0;
    }
}
