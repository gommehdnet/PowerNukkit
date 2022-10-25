package cn.nukkit.block;

/**
 * @author Angelic47 (Nukkit Project)
 */
public class BlockWater extends BlockFlowingWater {

    public BlockWater() {
        super(0);
    }

    public BlockWater(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.WATER;
    }

    @Override
    public String getName() {
        return "Still Water";
    }

    @Override
    public BlockLiquid getBlock(int meta) {
        return (BlockLiquid) Block.get(BlockID.WATER, meta);
    }

}
