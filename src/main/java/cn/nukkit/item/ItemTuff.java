package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemTuff extends Item {

    public ItemTuff() {
        this(0, 1);
    }

    public ItemTuff(Integer meta) {
        this(meta, 1);
    }

    public ItemTuff(Integer meta, int count) {
        super(ItemID.TUFF, meta, count, "Tuff");
        this.block = Block.get(BlockID.TUFF, meta);
    }
}