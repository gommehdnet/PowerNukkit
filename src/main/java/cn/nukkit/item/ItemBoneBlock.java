package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemBoneBlock extends Item {

    public ItemBoneBlock() {
        this(0, 1);
    }

    public ItemBoneBlock(Integer meta) {
        this(meta, 1);
    }

    public ItemBoneBlock(Integer meta, int count) {
        super(ItemID.BONE_BLOCK, meta, count, "Bone Block");
        this.block = Block.get(BlockID.BONE_BLOCK, meta);
    }
}