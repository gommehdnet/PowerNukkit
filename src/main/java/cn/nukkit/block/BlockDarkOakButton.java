package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockDarkOakButton extends BlockWoodenButton {
    @PowerNukkitOnly
    public BlockDarkOakButton() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockDarkOakButton(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.DARK_OAK_BUTTON;
    }
    
    @Override
    public String getName() {
        return "Dark Oak Button";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DARK_OAK_BUTTON);
    }
}
