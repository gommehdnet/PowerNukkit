package cn.nukkit.dispenser;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.block.BlockID;
import cn.nukkit.item.ItemID;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CreeperFace
 */
public final class DispenseBehaviorRegister {

    private static final Map<String, DispenseBehavior> behaviors = new HashMap<>();
    private static DispenseBehavior defaultBehavior = new DefaultDispenseBehavior();

    public static void registerBehavior(String id, DispenseBehavior behavior) {
        behaviors.put(id, behavior);
    }

    public static DispenseBehavior getBehavior(int id) {
        return behaviors.getOrDefault(id, defaultBehavior);
    }

    public static void removeDispenseBehavior(int id) {
        behaviors.remove(id);
    }

    @PowerNukkitOnly
    public static void init() {
        registerBehavior(ItemID.BOAT.getIdentifier(), new BoatDispenseBehavior());
        registerBehavior(ItemID.BUCKET.getIdentifier(), new BucketDispenseBehavior());
        registerBehavior(ItemID.DYE.getIdentifier(), new DyeDispenseBehavior());
        registerBehavior(ItemID.FIREWORK_ROCKET.getIdentifier(), new FireworksDispenseBehavior());
        registerBehavior(ItemID.FLINT_AND_STEEL.getIdentifier(), new FlintAndSteelDispenseBehavior());
        registerBehavior(BlockID.SHULKER_BOX.getIdentifier(), new ShulkerBoxDispenseBehavior());
        registerBehavior(BlockID.UNDYED_SHULKER_BOX.getIdentifier(), new ShulkerBoxDispenseBehavior());
        registerBehavior(ItemID.SPAWN_EGG.getIdentifier(), new SpawnEggDispenseBehavior());
        registerBehavior(BlockID.TNT.getIdentifier(), new TNTDispenseBehavior());
        registerBehavior(ItemID.ARROW.getIdentifier(), new ProjectileDispenseBehavior("Arrow") {
            @Override
            protected double getMotion() {
                return super.getMotion() * 1.5;
            }
        });
        //TODO: tipped arrow
        //TODO: spectral arrow
        registerBehavior(ItemID.EGG.getIdentifier(), new ProjectileDispenseBehavior("Egg"));
        registerBehavior(ItemID.SNOWBALL.getIdentifier(), new ProjectileDispenseBehavior("Snowball"));
        registerBehavior(ItemID.EXPERIENCE_BOTTLE.getIdentifier(), new ProjectileDispenseBehavior("ThrownExpBottle") {
            @Override
            protected float getAccuracy() {
                return super.getAccuracy() * 0.5f;
            }

            @Override
            protected double getMotion() {
                return super.getMotion() * 1.25;
            }
        });
        registerBehavior(ItemID.SPLASH_POTION.getIdentifier(), new ProjectileDispenseBehavior("ThrownPotion") {
            @Override
            protected float getAccuracy() {
                return super.getAccuracy() * 0.5f;
            }

            @Override
            protected double getMotion() {
                return super.getMotion() * 1.25;
            }
        });
//        registerBehavior(ItemID.LINGERING_POTION, new ProjectileDispenseBehavior("LingeringPotion")); //TODO
        registerBehavior(ItemID.TRIDENT.getIdentifier(), new ProjectileDispenseBehavior("ThrownTrident") {
            @Override
            protected float getAccuracy() {
                return super.getAccuracy() * 0.5f;
            }

            @Override
            protected double getMotion() {
                return super.getMotion() * 1.25;
            }
        });
    }
}
