package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;

@Since("1.4.0.0-PN")
public class ItemNetheriteScrap extends Item {

    @Since("1.4.0.0-PN")
    public ItemNetheriteScrap() {
        this(0, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheriteScrap(Integer meta) {
        this(meta, 1);
    }

    @Since("1.4.0.0-PN")
    public ItemNetheriteScrap(Integer meta, int count) {
        super(ItemID.NETHERITE_SCRAP, 0, count, "Netherite Scrap");
    }

    @PowerNukkitOnly
    @Override
    public boolean isLavaResistant() {
        return true;
    }
}
