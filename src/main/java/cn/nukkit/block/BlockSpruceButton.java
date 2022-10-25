package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockSpruceButton extends BlockWoodenButton {
    @PowerNukkitOnly
    public BlockSpruceButton() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockSpruceButton(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.SPRUCE_BUTTON;
    }
    
    @Override
    public String getName() {
        return "Spruce Button";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.SPRUCE_BUTTON);
    }
}
