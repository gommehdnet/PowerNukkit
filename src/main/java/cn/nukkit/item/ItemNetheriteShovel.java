package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;

@Since("1.4.0.0-PN")
public class ItemNetheriteShovel extends ItemTool {

    @Since("1.4.0.0-PN")
    public ItemNetheriteShovel() {
        this(0, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheriteShovel(Integer meta) {
        this(meta, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheriteShovel(Integer meta, int count) {
        super(ItemID.NETHERITE_SHOVEL, meta, count, "Netherite Shovel");
    }

    @Override
    public int getMaxDurability() {
        return ItemTool.DURABILITY_NETHERITE;
    }

    @Override
    public boolean isShovel() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_NETHERITE;
    }

    @Override
    public int getAttackDamage() {
        return 5;
    }

    @PowerNukkitOnly
    @Override
    public boolean isLavaResistant() {
        return true;
    }
}
