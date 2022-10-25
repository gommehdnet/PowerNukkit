package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMelonStem extends Item {

    public ItemMelonStem() {
        this(0, 1);
    }

    public ItemMelonStem(Integer meta) {
        this(meta, 1);
    }

    public ItemMelonStem(Integer meta, int count) {
        super(ItemID.MELON_STEM, meta, count, "Melon Stem");
        this.block = Block.get(BlockID.MELON_STEM, meta);
    }
}