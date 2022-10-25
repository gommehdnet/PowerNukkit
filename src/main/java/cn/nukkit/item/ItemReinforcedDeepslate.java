package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemReinforcedDeepslate extends Item {

    public ItemReinforcedDeepslate() {
        this(0, 1);
    }

    public ItemReinforcedDeepslate(Integer meta) {
        this(meta, 1);
    }

    public ItemReinforcedDeepslate(Integer meta, int count) {
        super(ItemID.REINFORCED_DEEPSLATE, meta, count, "Reinforced Deepslate");
        this.block = Block.get(BlockID.REINFORCED_DEEPSLATE, meta);
    }
}