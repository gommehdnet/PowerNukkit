package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemOakSign extends ItemSign {

    public ItemOakSign() {
        this(0, 1);
    }

    public ItemOakSign(Integer meta) {
        this(meta, 1);
    }

    public ItemOakSign(Integer meta, int count) {
        super(ItemID.OAK_SIGN, meta, count, "Oak Sign");
        this.block = Block.get(BlockID.STANDING_SIGN);
    }
}