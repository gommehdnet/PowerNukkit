package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class ItemWarpedDoor extends Item {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public ItemWarpedDoor() {
        this(0, 1);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public ItemWarpedDoor(Integer meta) {
        this(meta, 1);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public ItemWarpedDoor(Integer meta, int count) {
        super(ItemID.WARPED_DOOR, 0, count, "Warped Door");
        this.block = Block.get(BlockID.WARPED_DOOR);
    }

}
