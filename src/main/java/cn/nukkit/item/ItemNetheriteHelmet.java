package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;

@Since("1.4.0.0-PN")
public class ItemNetheriteHelmet extends ItemArmor {

    @Since("1.4.0.0-PN")
    public ItemNetheriteHelmet() {
        this(0, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheriteHelmet(Integer meta) {
        this(meta, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheriteHelmet(Integer meta, int count) {
        super(ItemID.NETHERITE_HELMET, meta, count, "Netherite Helmet");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_NETHERITE;
    }

    @Override
    public boolean isHelmet() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 3;
    }

    @Override
    public int getMaxDurability() {
        return 407;
    }

    @Override
    public int getToughness() {
        return 3;
    }

    @PowerNukkitOnly
    @Override
    public boolean isLavaResistant() {
        return true;
    }
}
