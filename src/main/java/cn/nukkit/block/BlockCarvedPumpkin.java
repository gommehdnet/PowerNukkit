package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

@PowerNukkitOnly
public class BlockCarvedPumpkin extends BlockPumpkin {

    @PowerNukkitOnly
    public BlockCarvedPumpkin() {
        super();
    }

    @Override
    public BlockID getId() {
        return BlockID.CARVED_PUMPKIN;
    }
    
    @Override
    public String getName() {
        return "Carved Pumpkin";
    }
    
    @Override
    public boolean canBeActivated() {
        return false;
    }
    
    @Override
    public boolean onActivate(@Nonnull Item item, Player player) {
        return false;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CARVED_PUMPKIN);
    }
}
