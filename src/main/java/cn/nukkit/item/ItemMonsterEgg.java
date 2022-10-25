package cn.nukkit.item;

import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemMonsterEgg extends Item {

    public ItemMonsterEgg() {
        this(0, 1);
    }

    public ItemMonsterEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemMonsterEgg(Integer meta, int count) {
        super(ItemID.MONSTER_EGG, meta, count, "Monster Egg");
        this.block = Block.get(BlockID.MONSTER_EGG, meta);
    }
}