package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.ArrayBlockProperty;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.value.WoodType;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

import static cn.nukkit.blockproperty.CommonBlockProperties.PILLAR_AXIS;

@PowerNukkitOnly
public class BlockLog extends BlockWood {

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public static final BlockProperties PROPERTIES = new BlockProperties(
            new ArrayBlockProperty<>("old_log_type", true, WoodType.values()),
            PILLAR_AXIS
    );

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockLog() {
        this(0);
    }

    @PowerNukkitOnly
    @Since("1.4.0.0-PN")
    public BlockLog(int meta) {
        super(meta);
    }

    @Override
    public BlockID getId() {
        return BlockID.LOG;
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    @Override
    public String getName() {
        return getWoodType().getEnglishName() + " Wood";
    }

    @PowerNukkitOnly
    @Override
    public WoodType getWoodType() {
        return getPropertyValue(WoodType.PROPERTY);
    }

    @PowerNukkitOnly
    @Override
    public void setWoodType(WoodType woodType) {
        setPropertyValue(WoodType.PROPERTY, woodType);
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.LOG, this.getDamage());
    }
}
