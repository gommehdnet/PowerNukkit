package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemJungleButton extends Item {

    public ItemJungleButton() {
        this(0, 1);
    }

    public ItemJungleButton(Integer meta) {
        this(meta, 1);
    }

    public ItemJungleButton(Integer meta, int count) {
        super(ItemID.JUNGLE_BUTTON, meta, count, "Jungle Button");
        this.block = Block.get(BlockID.JUNGLE_BUTTON, meta);
    }
}