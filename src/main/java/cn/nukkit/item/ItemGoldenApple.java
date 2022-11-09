package cn.nukkit.item;

import cn.nukkit.Player;
import cn.nukkit.math.Vector3;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGoldenApple extends ItemEdible {

    public ItemGoldenApple() {
        this(0, 1);
    }

    public ItemGoldenApple(Integer meta) {
        this(meta, 1);
    }

    public ItemGoldenApple(Integer meta, int count) {
        super(ItemID.GOLDEN_APPLE, meta, count, "Golden Apple");
    }

    @Override
    public boolean onClickAir(Player player, Vector3 directionVector) {
        return true;
    }
}