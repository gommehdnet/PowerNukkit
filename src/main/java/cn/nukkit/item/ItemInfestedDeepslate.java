package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemInfestedDeepslate extends Item {

    public ItemInfestedDeepslate() {
        this(0, 1);
    }

    public ItemInfestedDeepslate(Integer meta) {
        this(meta, 1);
    }

    public ItemInfestedDeepslate(Integer meta, int count) {
        super(ItemID.INFESTED_DEEPSLATE, meta, count, "Infested Deepslate");
        this.block = Block.get(BlockID.INFESTED_DEEPSLATE, meta);
    }
}