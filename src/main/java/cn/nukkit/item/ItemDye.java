package cn.nukkit.item;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.utils.DyeColor;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class ItemDye extends Item {

    public ItemDye(ItemID itemID, Integer meta, int amount, String name) {
        super(itemID, meta, amount, name);
    }

    public ItemDye(ItemID itemID, Integer meta, int amount) {
        super(itemID, meta, amount, "Dye");
    }


    public ItemDye(Integer meta, int amount) {
        super(ItemID.DYE, meta, amount, "Dye");
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Override
    public boolean isFertilizer() {
        return this.getIdentifier().equals(ItemID.WHITE_DYE);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public boolean isLapisLazuli() {
        return this.getIdentifier().equals(ItemID.BLUE_DYE);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    public boolean isCocoaBeans() {
        return this.getIdentifier().equals(ItemID.BROWN_DYE);
    }

    public DyeColor getDyeColor() {
        if (this.identifier.equals(ItemID.DYE)) {
            return DyeColor.BLACK;
        }

        for (DyeColor color : DyeColor.values()) {
            if (color.name().toLowerCase().equalsIgnoreCase(this.identifier.getIdentifier().split("_dye")[0])) {
                return color;
            }
        }

        return DyeColor.BLACK;
    }
}