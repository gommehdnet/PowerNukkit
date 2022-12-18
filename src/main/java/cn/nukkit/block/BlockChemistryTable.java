package cn.nukkit.block;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.ArrayBlockProperty;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.CommonBlockProperties;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;

import javax.annotation.Nonnull;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockChemistryTable extends Block {

    public static BlockProperties PROPERTIES = new BlockProperties(new ArrayBlockProperty<>("chemistry_table_type", false, new String[]{"compound_creator", "material_reducer", "element_constructor", "lab_table"}), CommonBlockProperties.DIRECTION);

    @Override
    public BlockID getId() {
        return BlockID.CHEMISTRY_TABLE;
    }

    @Override
    public String getName() {
        return "Chemistry Table";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.CHEMISTRY_TABLE);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }
}