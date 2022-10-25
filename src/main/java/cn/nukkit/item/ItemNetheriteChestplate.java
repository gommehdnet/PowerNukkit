package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;

@Since("1.4.0.0-PN")
public class ItemNetheriteChestplate extends ItemArmor {

    @Since("1.4.0.0-PN")
    public ItemNetheriteChestplate() {
        this(0, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheriteChestplate(Integer meta) {
        this(meta, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheriteChestplate(Integer meta, int count) {
        super(ItemID.NETHERITE_CHESTPLATE, meta, count, "Netherite Chestplate");
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_NETHERITE;
    }

    @Override
    public boolean isChestplate() {
        return true;
    }

    @Override
    public int getArmorPoints() {
        return 8;
    }

    @Override
    public int getMaxDurability() {
        return 592;
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
