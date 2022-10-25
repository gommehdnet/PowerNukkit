package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemAnvil extends Item {

    public ItemAnvil() {
        this(0, 1);
    }

    public ItemAnvil(Integer meta) {
        this(meta, 1);
    }

    public ItemAnvil(Integer meta, int count) {
        super(ItemID.ANVIL, meta, count, "Anvil");
        this.block = Block.get(BlockID.ANVIL, meta);
    }
}