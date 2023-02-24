package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockBuddingAmethyst extends Block {

    @Override
    public BlockID getId() {
        return BlockID.BUDDING_AMETHYST;
    }

    @Override
    public String getName() {
        return "Budding Amethyst";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BUDDING_AMETHYST);
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public double getResistance() {
        return 1.5;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @PowerNukkitOnly
    @Override
    public boolean canBePulled() {
        return false;
    }

    @Override
    public Item[] getDrops(Item item) {
        return Item.EMPTY_ARRAY;
    }

    @Override
    public boolean canHarvestWithHand() {
        return false;
    }
}