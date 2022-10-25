package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

@PowerNukkitOnly
@Since("1.4.0.0-PN")
public class BlockCrimsonButton extends BlockWoodenButton {
    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockCrimsonButton() {
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockCrimsonButton(int meta) {
        super(meta);
    }
    
    @Override
    public BlockID getId() {
        return BlockID.CRIMSON_BUTTON;
    }
    
    @Override
    public String getName() {
        return "Crimson Button";
    }
    
    @Override
    public int getBurnChance() {
        return 0;
    }
    
    @Override
    public int getBurnAbility() {
        return 0;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CRIMSON_BUTTON);
    }
}
