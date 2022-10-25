package cn.nukkit.block;

import cn.nukkit.entity.Entity;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemTool;
import cn.nukkit.math.AxisAlignedBB;
import cn.nukkit.utils.BlockColor;

/**
 * @author Nukkit Project Team
 */
public class BlockWoodenPressurePlate extends BlockPressurePlateBase {

    public BlockWoodenPressurePlate(int meta) {
        super(meta);
        this.onPitch = 0.8f;
        this.offPitch = 0.7f;
    }

    public BlockWoodenPressurePlate() {
        this(0);
    }

    @Override
    public String getName() {
        return "Oak Pressure Plate";
    }

    @Override
    public BlockID getId() {
        return BlockID.WOODEN_PRESSURE_PLATE;
    }

    @Override
    public int getToolType() {
         return ItemTool.TYPE_AXE;
    }

    @Override
    public double getHardness() {
        return 0.5D;
    }

    @Override
    public double getResistance() {
        return 0.5D;
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.WOOD_BLOCK_COLOR;
    }

    @Override
    protected int computeRedstoneStrength() {
        AxisAlignedBB bb = getCollisionBoundingBox();

        for (Entity entity : this.level.getCollidingEntities(bb)) {
            if (entity.doesTriggerPressurePlate()) {
                return 15;
            }
        }

        return 0;
    }

    @Override
    public Item toItem() {
        return Item.get(ItemID.WOODEN_PRESSURE_PLATE);
    }
}
