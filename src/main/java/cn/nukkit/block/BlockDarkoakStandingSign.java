package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockDarkoakStandingSign extends BlockStandingSign {

    @Override
    public BlockID getId() {
        return BlockID.DARKOAK_STANDING_SIGN;
    }

    @PowerNukkitOnly
    @Override
    public BlockID getWallId() {
        return BlockID.DARKOAK_WALL_SIGN;
    }

    @Override
    public String getName() {
        return "Darkoak Standing Sign";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.DARK_OAK_SIGN);
    }
}