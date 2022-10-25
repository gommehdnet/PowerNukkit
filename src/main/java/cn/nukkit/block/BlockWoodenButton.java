package cn.nukkit.block;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;

/**
 * @author CreeperFace
 * @since 27. 11. 2016
 */
public class BlockWoodenButton extends BlockButton {

    public BlockWoodenButton() {
        this(0);
    }

    public BlockWoodenButton(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.WOODEN_BUTTON;
    }

    @Override
    public String getName() {
        return "Oak Button";
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_AXE;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WOODEN_BUTTON);
    }
}
