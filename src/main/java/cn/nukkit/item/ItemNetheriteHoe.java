package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;

@Since("1.4.0.0-PN")
public class ItemNetheriteHoe extends ItemTool {

    @Since("1.4.0.0-PN")
    public ItemNetheriteHoe() {
        this(0, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheriteHoe(Integer meta) {
        this(meta, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheriteHoe(Integer meta, int count) {
        super(ItemID.NETHERITE_HOE, meta, count, "Netherite Hoe");
    }

    @Override
    public boolean isHoe() {
        return true;
    }

    @Override
    public int getAttackDamage() {
        return 6;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_NETHERITE;
    }

    @Override
    public int getMaxDurability() {
        return ItemTool.DURABILITY_NETHERITE;
    }

    @PowerNukkitOnly
    @Override
    public boolean isLavaResistant() {
        return true;
    }
}
