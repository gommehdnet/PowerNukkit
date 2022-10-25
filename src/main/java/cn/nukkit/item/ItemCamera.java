package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemCamera extends Item {

    public ItemCamera() {
        this(0, 1);
    }

    public ItemCamera(Integer meta) {
        this(meta, 1);
    }

    public ItemCamera(Integer meta, int count) {
        super(ItemID.CAMERA, meta, count, "Camera");
        this.block = Block.get(BlockID.CAMERA, meta);
    }
}