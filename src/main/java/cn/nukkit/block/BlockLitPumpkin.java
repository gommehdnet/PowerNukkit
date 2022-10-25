package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author xtypr
 * @since 2015/12/8
 */
public class BlockLitPumpkin extends BlockPumpkin {
    public BlockLitPumpkin() {
        this(0);
    }

    public BlockLitPumpkin(int meta) {
        super(meta);
    }

    @Override
    public String getName() {
        return "Jack o'Lantern";
    }

    @Override
    public BlockID getId() {
        return BlockID.LIT_PUMPKIN;
    }

    @Override
    public int getLightLevel() {
        return 15;
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
        return Item.get(ItemID.LIT_PUMPKIN);
    }
}
