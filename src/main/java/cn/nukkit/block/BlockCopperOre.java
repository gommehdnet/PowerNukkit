package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemDiamond;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.item.enchantment.Enchantment;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
    public double getHardness() {
        return 4.5;
    }

    @Override
    public double getResistance() {
        return 3;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public int getToolTier() {
        return ItemTool.TIER_STONE;
    }

    @Override
    public Item[] getDrops(Item item) {
        if (item.isPickaxe() && item.getTier() >= getToolTier()) {
            int count = Math.max(2, new Random().nextInt(5));

            Enchantment fortune = item.getEnchantment(Enchantment.ID_FORTUNE_DIGGING);

            if (fortune != null && fortune.getLevel() >= 1) {
                int i = ThreadLocalRandom.current().nextInt(fortune.getLevel() + 2) - 1;

                if (i < 0) {
                    i = 0;
                }

                count = i + 1;
            }

            return new Item[]{Item.get(ItemID.RAW_COPPER, 0, count)};
        } else {
            return Item.EMPTY_ARRAY;
        }
    }

    @Override
    public boolean canSilkTouch() {
        return true;
    }
}