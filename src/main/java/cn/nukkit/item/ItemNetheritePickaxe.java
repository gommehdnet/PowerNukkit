package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;

@Since("1.4.0.0-PN")
public class ItemNetheritePickaxe extends ItemTool {

    @Since("1.4.0.0-PN")
    public ItemNetheritePickaxe() {
        this(0, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheritePickaxe(Integer meta) {
        this(meta, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheritePickaxe(Integer meta, int count) {
        super(ItemID.NETHERITE_PICKAXE, meta, count, "Netherite Pickaxe");
    }

    @Override
    public int getMaxDurability() {
        return ItemTool.DURABILITY_NETHERITE;
    }

    @Override
    public boolean isPickaxe() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemTool.TIER_NETHERITE;
    }

    @Override
    public int getAttackDamage() {
        return 6;
    }

    @PowerNukkitOnly
    @Override
    public boolean isLavaResistant() {
        return true;
    }
}
