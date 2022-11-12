package cn.nukkit.entity.passive;

import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

import java.util.Random;
import java.util.SplittableRandom;

/**
 * @author Kaooot
 * @version 1.0
 */
public class EntityGoat extends EntityAnimal {

    public static final int NETWORK_ID = 128;

    private boolean isScreaming = false;

    public EntityGoat(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return EntityGoat.NETWORK_ID;
    }

    @Override
    public float getWidth() {
        if (this.isBaby()) {
            return 0.45f;
        }

        return 0.9f;
    }

    @Override
    public float getHeight() {
        if (this.isBaby()) {
            return 0.65f;
        }

        return 1.3f;
    }

    @Override
    protected void initEntity() {
        super.initEntity();
        this.setMaxHealth(10);

        if (new Random().nextDouble() <= 0.02) {
            this.isScreaming = true;
        }
    }

    @Override
    public Item[] getDrops() {
        return this.isBaby() ? Item.EMPTY_ARRAY : new Item[]{Item.get(ItemID.GOAT_HORN, new SplittableRandom().nextInt(this.isScreaming ? 4 : 0, this.isScreaming ? 8 : 4))};
    }
}