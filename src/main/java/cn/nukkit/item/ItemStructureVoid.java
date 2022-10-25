package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStructureVoid extends Item {

    public ItemStructureVoid() {
        this(0, 1);
    }

    public ItemStructureVoid(Integer meta) {
        this(meta, 1);
    }

    public ItemStructureVoid(Integer meta, int count) {
        super(ItemID.STRUCTURE_VOID, meta, count, "Structure Void");
        this.block = Block.get(BlockID.STRUCTURE_VOID, meta);
    }
}