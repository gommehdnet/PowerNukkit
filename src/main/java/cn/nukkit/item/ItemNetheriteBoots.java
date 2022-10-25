package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;

@Since("1.4.0.0-PN")
public class ItemNetheriteBoots extends ItemArmor {

    @Since("1.4.0.0-PN")
    public ItemNetheriteBoots() {
        this(0, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheriteBoots(Integer meta) {
        this(meta, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheriteBoots(Integer meta, int count) {
        super(ItemID.NETHERITE_BOOTS, meta, count, "Netherite Boots");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_NETHERITE;
    }

    @Override
    public boolean isBoots() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 3;
    }

    @Override
    public int getMaxDurability() {
        return 481;
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
