package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.item.enchantment.Enchantment;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockHangingRoots extends BlockTransparent {

    @Override
    public BlockID getId() {
        return BlockID.HANGING_ROOTS;
    }

    @Override
    public String getName() {
        return "Hanging Roots";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.HANGING_ROOTS);
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_SHEARS;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public int getBurnChance() {
        return 30;
    }

    @Override
    public int getBurnAbility() {
        return 60;
    }

    @Override
    public boolean canSilkTouch() {
        return true;
    }

    @Override
    public Item[] getDrops(Item item) {
        if ((item.isTool() && item.hasEnchantment(Enchantment.ID_SILK_TOUCH)) || item.isShears()) {
            return new Item[]{this.toItem()};
        }

        return Item.EMPTY_ARRAY;
    }
}