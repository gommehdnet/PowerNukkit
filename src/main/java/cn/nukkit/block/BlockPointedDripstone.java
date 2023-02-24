package cn.nukkit.block;

import cn.nukkit.Player;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.blockproperty.ArrayBlockProperty;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.BooleanBlockProperty;
import cn.nukkit.entity.Entity;
import cn.nukkit.entity.projectile.EntityThrownTrident;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.math.BlockFace;
import cn.nukkit.utils.Faceable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author Kaooot
 * @version 1.0
 */
public class BlockPointedDripstone extends Block {

    public static final BlockProperties PROPERTIES = new BlockProperties(new ArrayBlockProperty<>("dripstone_thickness", true, DripstoneThickness.values()),
            new BooleanBlockProperty("hanging", false));

    @Override
    public BlockID getId() {
        return BlockID.POINTED_DRIPSTONE;
    }

    @Override
    public String getName() {
        return "Pointed Dripstone";
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.POINTED_DRIPSTONE);
    }

    @Since("1.4.0.0-PN")
    @PowerNukkitOnly
    @Nonnull
    @Override
    public BlockProperties getProperties() {
        return PROPERTIES;
    }

    @Override
    public double getHardness() {
        return 1.5;
    }

    @Override
    public double getResistance() {
        return 3;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    public enum DripstoneThickness {
        TIP,
        FRUSTUM,
        MIDDLE,
        BASE,
        MERGE
    }

    @Override
    public void onEntityCollide(Entity entity) {
        if (entity instanceof EntityThrownTrident) {
            this.level.useBreakOn(this);
        }
    }

    @Override
    public boolean place(@Nonnull Item item, @Nonnull Block block, @Nonnull Block target, @Nonnull BlockFace face, double fx, double fy, double fz, @Nullable Player player) {
        this.setBooleanValue("hanging", face.equals(BlockFace.DOWN));

        return super.place(item, block, target, face, fx, fy, fz, player);
    }
}