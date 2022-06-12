package cn.nukkit.entity.passive;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.level.format.FullChunk;
import cn.nukkit.nbt.tag.CompoundTag;

/**
 * @author Kaooot
 * @version 1.0
 */
public class EntityTadpole extends EntityAnimal {

    public static final int NETWORK_ID = 133;

    public EntityTadpole(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }

    @Override
    public int getNetworkId() {
        return NETWORK_ID;
    }

    @Since("1.5.1.0-PN")
    @PowerNukkitOnly
    @Override
    public String getOriginalName() {
        return "Tadpole";
    }

    @Override
    public float getWidth() {
        return 0.8f;
    }

    @Override
    public float getHeight() {
        return 0.6f;
    }

    @Override
    protected void initEntity() {
        super.initEntity();
        this.setMaxHealth(6);
    }
}