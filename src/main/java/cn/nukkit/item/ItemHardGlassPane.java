package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemHardGlassPane extends Item {

    public ItemHardGlassPane() {
        this(0, 1);
    }

    public ItemHardGlassPane(Integer meta) {
        this(meta, 1);
    }

    public ItemHardGlassPane(Integer meta, int count) {
        super(ItemID.HARD_GLASS_PANE, meta, count, "Hard Glass Pane");
        this.block = Block.get(BlockID.HARD_GLASS_PANE, meta);
    }
}