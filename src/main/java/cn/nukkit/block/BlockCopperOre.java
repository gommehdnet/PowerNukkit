package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.enchantment.Enchantment;

import java.util.Random;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockCopperOre extends Block {

    @Override
    public BlockID getId() {
        return BlockID.COPPER_ORE;
    }

    @Override
    public String getName() {
        return "Copper Ore";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.COPPER_ORE);
    }

    @Override
    public Item[] getDrops(Item item) {
        return item.hasEnchantment(Enchantment.ID_SILK_TOUCH) ? new Item[]{Item.get(ItemID.COPPER_INGOT, 0, Math.max(2, new Random().nextInt(5)))} : new Item[]{this.toItem()};
    }
}