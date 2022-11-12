package cn.nukkit.entity.passive;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

import java.util.Random;

/**
 * @author Kaooot
 * @version 1.0
 */
public class EntityGlowSquid extends EntityAnimal {

    public static final int NETWORK_ID = 129;

    public EntityGlowSquid(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return EntityGlowSquid.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        if (this.isBaby()) {
            return 0.475f;
        }

        return 0.95f;
    }

    @Override
    public float getHeight() {
        if (this.isBaby()) {
            return 0.475f;
        }

        return 0.95f;
    }

    @Override
    protected void initEntity() {
        super.initEntity();
        this.setMaxHealth(10);
    }

    @Override
    public Item[] getDrops() {
        return this.isBaby() ? Item.EMPTY_ARRAY : new Item[]{Item.get(ItemID.GLOW_INK_SAC, 0, Math.max(1, new Random().nextInt(3) + 1))};
    }
}