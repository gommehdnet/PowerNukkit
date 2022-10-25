package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;

/**
 * @author CreeperFace
 * @since 27. 11. 2016
 */
public class BlockStoneButton extends BlockButton {

    public BlockStoneButton() {
        this(0);
    }

    public BlockStoneButton(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.STONE_BUTTON;
    }

    @Override
    public String getName() {
        return "Stone Button";
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    @PowerNukkitOnly
    public int getToolTier() {
        return ItemTool.TIER_WOODEN;
    }

    @PowerNukkitDifference(since = "1.4.0.0-PN", info = "Will return false")
    @Override
    public boolean canHarvestWithHand() {
        return false;
    }

    @PowerNukkitDifference(since = "1.4.0.0-PN", info = "Requires wooden pickaxe to drop item")
    @Override
    public Item[] getDrops(Item item) {
        return super.getDrops(item);
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.STONE_BUTTON);
    }
}
