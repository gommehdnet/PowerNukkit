package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHardStainedGlassPane extends Item {

    public ItemHardStainedGlassPane() {
        this(0, 1);
    }

    public ItemHardStainedGlassPane(Integer meta) {
        this(meta, 1);
    }

    public ItemHardStainedGlassPane(Integer meta, int count) {
        super(ItemID.HARD_STAINED_GLASS_PANE, meta, count, "Hard Stained Glass Pane");
        this.block = Block.get(BlockID.HARD_STAINED_GLASS_PANE, meta);
    }
}