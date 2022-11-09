package cn.nukkit.item;

import cn.nukkit.Player;
import cn.nukkit.math.Vector3;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemEnchantedGoldenApple extends ItemEdible {

    public ItemEnchantedGoldenApple() {
        this(0, 1);
    }

    public ItemEnchantedGoldenApple(Integer meta) {
        this(meta, 1);
    }

    public ItemEnchantedGoldenApple(Integer meta, int count) {
        super(ItemID.ENCHANTED_GOLDEN_APPLE, meta, count, "Enchanted Golden Apple");
    }

    @Override
    public boolean onClickAir(Player player, Vector3 directionVector) {
        return true;
    }
}