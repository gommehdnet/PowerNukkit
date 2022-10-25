package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGlassPane extends Item {

    public ItemGlassPane() {
        this(0, 1);
    }

    public ItemGlassPane(Integer meta) {
        this(meta, 1);
    }

    public ItemGlassPane(Integer meta, int count) {
        super(ItemID.GLASS_PANE, meta, count, "Glass Pane");
        this.block = Block.get(BlockID.GLASS_PANE, meta);
    }
}