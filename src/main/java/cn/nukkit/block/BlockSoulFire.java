package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.level.Level;
import cn.nukkit.utils.BlockColor;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockSoulFire extends BlockFire {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockSoulFire(){
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockSoulFire(int meta){
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.SOUL_FIRE;
    }

    @Override
    public String getName() {
        return "Soul Fire Block";
    }

    @Override
    public int onUpdate(int type) {
        if (type == Level.BLOCK_UPDATE_NORMAL) {
            BlockID downId = down().getId();
            if (downId != BlockID.SOUL_SAND && downId != BlockID.SOUL_SOIL) {
                this.getLevel().setBlock(this, getCurrentState().withBlockId(BlockID.FIRE).getBlock(this));
            }
            return type;
        }
        return 0;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.WATER_BLOCK_COLOR;
    }
}
