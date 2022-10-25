package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;

@Since("1.4.0.0-PN")
public class ItemNetheriteIngot extends Item {

    @Since("1.4.0.0-PN")
    public ItemNetheriteIngot() {
        this(0, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheriteIngot(Integer meta) {
        this(meta, 1);
    }

    public ItemNetheriteIngot(Integer meta, int count) {
        super(ItemID.NETHERITE_INGOT, 0, count, "Netherite Ingot");
    }

    @PowerNukkitOnly
    @Override
    public boolean isLavaResistant() {
        return true;
    }
}
