package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.UnsignedIntBlockProperty;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class BlockUnknown extends BlockMeta {
    @PowerNukkitOnly
    @Since("1.5.0.0-PN")
    public static final UnsignedIntBlockProperty UNKNOWN = new UnsignedIntBlockProperty("nukkit-unknown", true, 0xFFFFFFFF);

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static final BlockProperties PROPERTIES = new BlockProperties(UNKNOWN);

    public BlockUnknown() {
        this(0);
    }

    public BlockUnknown(Integer meta) {
        super(0);
        if (meta != null && meta != 0) {
            getMutableState().setDataStorageFromInt(meta, false);
        }
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    @Override
    public BlockID getId() {
        return BlockID.UNKNOWN;
    }

    @Override
    public String getName() {
        return "Unknown";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.UNKNOWN);
    }
}
