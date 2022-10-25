package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.utils.BlockColor;

/**
 * @author xtypr
 * @since 2015/11/23
 */
public class BlockAcaciaFenceGate extends BlockFenceGate {
    public BlockAcaciaFenceGate() {
        this(0);
    }

    public BlockAcaciaFenceGate(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.ACACIA_FENCE_GATE;
    }

    @Override
    public String getName() {
        return "Acacia Fence Gate";
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.ORANGE_BLOCK_COLOR;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.ACACIA_FENCE_GATE);
    }
}