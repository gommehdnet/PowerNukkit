package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemStainedGlassPane extends Item {

    public ItemStainedGlassPane() {
        this(0, 1);
    }

    public ItemStainedGlassPane(Integer meta) {
        this(meta, 1);
    }

    public ItemStainedGlassPane(Integer meta, int count) {
        super(ItemID.STAINED_GLASS_PANE, meta, count, "Stained Glass Pane");
        this.block = Block.get(BlockID.STAINED_GLASS_PANE, meta);
    }
}