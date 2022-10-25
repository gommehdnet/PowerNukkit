package cn.nukkit.item;

/**
 * @author Kaooot
 * @version 1.0
 */
public class ItemGlowSquidSpawnEgg extends Item {

    public ItemGlowSquidSpawnEgg() {
        this(0, 1);
    }

    public ItemGlowSquidSpawnEgg(Integer meta) {
        this(meta, 1);
    }

    public ItemGlowSquidSpawnEgg(Integer meta, int count) {
        super(ItemID.GLOW_SQUID_SPAWN_EGG, meta, count, "Glow Squid Spawn Egg");
    }
}