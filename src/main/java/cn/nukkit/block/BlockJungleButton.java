package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
public class BlockJungleButton extends BlockWoodenButton {
    @PowerNukkitOnly
    public BlockJungleButton() {
        this(0);
    }

    @PowerNukkitOnly
    public BlockJungleButton(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.JUNGLE_BUTTON;
    }
    
    @Override
    public String getName() {
        return "Jungle Button";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.JUNGLE_BUTTON);
    }
}
