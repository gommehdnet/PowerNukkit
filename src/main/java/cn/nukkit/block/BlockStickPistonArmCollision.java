package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;

@PowerNukkitOnly
public class BlockStickPistonArmCollision extends BlockPistonArmCollision {
    @PowerNukkitOnly
    public BlockStickPistonArmCollision() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockStickPistonArmCollision(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.STICKY_PISTON_ARM_COLLISION;
    }
    
    @Override
    public String getName() {
        return "Sticky Piston Head";
    }
}
