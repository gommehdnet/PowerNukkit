package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class BlockAcaciaStairs extends BlockOakStairs {

    public BlockAcaciaStairs() {
        this(0);
    }

    public BlockAcaciaStairs(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.ACACIA_STAIRS;
    }

    @Override
    public String getName() {
        return "Acacia Wood Stairs";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.ORANGE_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.ACACIA_STAIRS);
    }

}