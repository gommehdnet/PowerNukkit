package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockBirchButton extends BlockWoodenButton {
    @PowerNukkitOnly
    public BlockBirchButton() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockBirchButton(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.BIRCH_BUTTON;
    }
    
    @Override
    public String getName() {
        return "Birch Button";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.BIRCH_BUTTON);
    }
}
