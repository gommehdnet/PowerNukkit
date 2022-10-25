package cn.nukkit.item.food;

import cn.nukkit.Player;
import cn.nukkit.api.DeprecationDetails;
import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import cn.nukkit.block.Block;
import cn.nukkit.block.BlockID;
import cn.nukkit.event.player.PlayerEatFoodEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemID;
import cn.nukkit.plugin.Plugin;
import cn.nukkit.potion.Effect;

import java.util.*;

/**
 * @author Snake1999
 * @since 2016/1/13
 */
@SuppressWarnings("StaticInitializerReferencesSubClass")
public abstract class Food {

    private static final Map<NodeIDMetaPlugin, Food> registryCustom = new LinkedHashMap<>();
    private static final Map<NodeIDMeta, Food> registryDefault = new LinkedHashMap<>();

    public static final Food apple = registerDefaultFood(new FoodNormal(4, 2.4F).addRelative(ItemID.APPLE.getIdentifier()));
    public static final Food apple_golden = registerDefaultFood(new FoodEffective(4, 9.6F)
            .addEffect(Effect.getEffect(Effect.REGENERATION).setAmplifier(1).setDuration(5 * 20))
            .addEffect(Effect.getEffect(Effect.ABSORPTION).setDuration(2 * 60 * 20))
            .addRelative(ItemID.GOLDEN_APPLE.getIdentifier()));
    public static final Food apple_golden_enchanted = registerDefaultFood(new FoodEffective(4, 9.6F)
            .addEffect(Effect.getEffect(Effect.REGENERATION).setAmplifier(4).setDuration(30 * 20))
            .addEffect(Effect.getEffect(Effect.ABSORPTION).setDuration(2 * 60 * 20).setAmplifier(3))
            .addEffect(Effect.getEffect(Effect.DAMAGE_RESISTANCE).setDuration(5 * 60 * 20))
            .addEffect(Effect.getEffect(Effect.FIRE_RESISTANCE).setDuration(5 * 60 * 20))
            .addRelative(ItemID.ENCHANTED_GOLDEN_APPLE.getIdentifier()));
    public static final Food beef_raw = registerDefaultFood(new FoodNormal(3, 1.8F).addRelative(ItemID.BEEF.getIdentifier()));
    public static final Food beetroot = registerDefaultFood(new FoodNormal(1, 1.2F).addRelative(ItemID.BEETROOT.getIdentifier()));
    public static final Food beetroot_soup = registerDefaultFood(new FoodInBowl(6, 7.2F).addRelative(ItemID.BEETROOT_SOUP.getIdentifier()));
    public static final Food bread = registerDefaultFood(new FoodNormal(5, 6F).addRelative(ItemID.BREAD.getIdentifier()));
    public static final Food cake_slice = registerDefaultFood(new FoodNormal(2, 0.4F)
            .addRelative(BlockID.CAKE.getIdentifier(), 0).addRelative(BlockID.CAKE.getIdentifier(), 1).addRelative(BlockID.CAKE.getIdentifier(), 2)
            .addRelative(BlockID.CAKE.getIdentifier(), 3).addRelative(BlockID.CAKE.getIdentifier(), 4).addRelative(BlockID.CAKE.getIdentifier(), 5)
            .addRelative(BlockID.CAKE.getIdentifier(), 6));
    public static final Food carrot = registerDefaultFood(new FoodNormal(3, 4.8F).addRelative(ItemID.CARROT.getIdentifier()));
    public static final Food carrot_golden = registerDefaultFood(new FoodNormal(6, 14.4F).addRelative(ItemID.GOLDEN_CARROT.getIdentifier()));
    public static final Food chicken_raw = registerDefaultFood(new FoodEffective(2, 1.2F)
            .addChanceEffect(0.3F, Effect.getEffect(Effect.HUNGER).setDuration(30 * 20))
            .addRelative(ItemID.CHICKEN.getIdentifier()));
    public static final Food chicken_cooked = registerDefaultFood(new FoodNormal(6, 7.2F).addRelative(ItemID.COOKED_CHICKEN.getIdentifier()));
    public static final Food chorus_fruit = registerDefaultFood(new FoodChorusFruit());
    public static final Food cookie = registerDefaultFood(new FoodNormal(2, 0.4F).addRelative(ItemID.COOKIE.getIdentifier()));
    public static final Food melon_slice = registerDefaultFood(new FoodNormal(2, 1.2F).addRelative(ItemID.MELON_SLICE.getIdentifier()));
    public static final Food milk = registerDefaultFood(new FoodMilk().addRelative(ItemID.BUCKET.getIdentifier(), 1));
    public static final Food mushroom_stew = registerDefaultFood(new FoodInBowl(6, 7.2F).addRelative(ItemID.MUSHROOM_STEW.getIdentifier()));
    public static final Food mutton_cooked = registerDefaultFood(new FoodNormal(6, 9.6F).addRelative(ItemID.COOKED_MUTTON.getIdentifier()));
    public static final Food mutton_raw = registerDefaultFood(new FoodNormal(2, 1.2F).addRelative(ItemID.MUTTON.getIdentifier()));
    public static final Food porkchop_cooked = registerDefaultFood(new FoodNormal(8, 12.8F).addRelative(ItemID.COOKED_PORKCHOP.getIdentifier()));
    public static final Food porkchop_raw = registerDefaultFood(new FoodNormal(3, 1.8F).addRelative(ItemID.PORKCHOP.getIdentifier()));
    public static final Food potato_raw = registerDefaultFood(new FoodNormal(1, 0.6F).addRelative(ItemID.POTATO.getIdentifier()));
    public static final Food potato_baked = registerDefaultFood(new FoodNormal(5, 7.2F).addRelative(ItemID.BAKED_POTATO.getIdentifier()));
    public static final Food potato_poisonous = registerDefaultFood(new FoodEffective(2, 1.2F)
            .addChanceEffect(0.6F, Effect.getEffect(Effect.POISON).setDuration(4 * 20))
            .addRelative(ItemID.POISONOUS_POTATO.getIdentifier()));
    public static final Food pumpkin_pie = registerDefaultFood(new FoodNormal(8, 4.8F).addRelative(ItemID.PUMPKIN_PIE.getIdentifier()));
    public static final Food rabbit_cooked = registerDefaultFood(new FoodNormal(5, 6F).addRelative(ItemID.COOKED_RABBIT.getIdentifier()));
    public static final Food rabbit_raw = registerDefaultFood(new FoodNormal(3, 1.8F).addRelative(ItemID.RABBIT.getIdentifier()));
    public static final Food rabbit_stew = registerDefaultFood(new FoodInBowl(10, 12F).addRelative(ItemID.RABBIT_STEW.getIdentifier()));
    public static final Food rotten_flesh = registerDefaultFood(new FoodEffective(4, 0.8F)
            .addChanceEffect(0.8F, Effect.getEffect(Effect.HUNGER).setDuration(30 * 20))
            .addRelative(ItemID.ROTTEN_FLESH.getIdentifier()));
    public static final Food spider_eye = registerDefaultFood(new FoodEffective(2, 3.2F)
            .addEffect(Effect.getEffect(Effect.POISON).setDuration(4 * 20))
            .addRelative(ItemID.SPIDER_EYE.getIdentifier()));
    public static final Food steak = registerDefaultFood(new FoodNormal(8, 12.8F).addRelative(ItemID.COOKED_BEEF.getIdentifier()));
    //different kinds of fishes
    public static final Food clownfish = registerDefaultFood(new FoodNormal(1, 0.2F).addRelative(ItemID.TROPICAL_FISH.getIdentifier()));
    public static final Food fish_cooked = registerDefaultFood(new FoodNormal(5, 6F).addRelative(ItemID.COOKED_COD.getIdentifier()));
    public static final Food fish_raw = registerDefaultFood(new FoodNormal(2, 0.4F).addRelative(ItemID.COD.getIdentifier()));
    public static final Food salmon_cooked = registerDefaultFood(new FoodNormal(6, 9.6F).addRelative(ItemID.COOKED_SALMON.getIdentifier()));
    public static final Food salmon_raw = registerDefaultFood(new FoodNormal(2, 0.4F).addRelative(ItemID.SALMON.getIdentifier()));
    public static final Food pufferfish = registerDefaultFood(new FoodEffective(1, 0.2F)
            .addEffect(Effect.getEffect(Effect.HUNGER).setAmplifier(2).setDuration(15 * 20))
            .addEffect(Effect.getEffect(Effect.NAUSEA).setAmplifier(1).setDuration(15 * 20))
            .addEffect(Effect.getEffect(Effect.POISON).setAmplifier(3).setDuration(60 * 20))
            .addRelative(ItemID.PUFFERFISH.getIdentifier()));
    public static final Food dried_kelp = registerDefaultFood(new FoodNormal(1, 0.6F).addRelative(ItemID.DRIED_KELP.getIdentifier()).setEatingTick(16));
    public static final Food sweet_berries = registerDefaultFood(new FoodNormal(2, 0.4F).addRelative(ItemID.SWEET_BERRIES.getIdentifier()));
    
    @PowerNukkitOnly
    public static final Food suspicious_stew_night_vision = registerDefaultFood(new FoodEffectiveInBow(6, 7.2F)
            .addEffect(Effect.getEffect(Effect.NIGHT_VISION).setAmplifier(1).setDuration(4 * 20)).addRelative(ItemID.SUSPICIOUS_STEW.getIdentifier(), 0));
    
    @PowerNukkitOnly
    public static final Food suspicious_stew_jump = registerDefaultFood(new FoodEffectiveInBow(6, 7.2F)
            .addEffect(Effect.getEffect(Effect.JUMP).setAmplifier(1).setDuration(4 * 20)).addRelative(ItemID.SUSPICIOUS_STEW.getIdentifier(), 1));
    
    @PowerNukkitOnly
    public static final Food suspicious_stew_weakness = registerDefaultFood(new FoodEffectiveInBow(6, 7.2F)
            .addEffect(Effect.getEffect(Effect.WEAKNESS).setAmplifier(1).setDuration(7 * 20)).addRelative(ItemID.SUSPICIOUS_STEW.getIdentifier(), 2));
    
    @PowerNukkitOnly
    public static final Food suspicious_stew_blindness = registerDefaultFood(new FoodEffectiveInBow(6, 7.2F)
            .addEffect(Effect.getEffect(Effect.BLINDNESS).setAmplifier(1).setDuration(6 * 20)).addRelative(ItemID.SUSPICIOUS_STEW.getIdentifier(), 3));

    @PowerNukkitOnly
    public static final Food suspicious_stew_poison = registerDefaultFood(new FoodEffectiveInBow(6, 7.2F)
            .addEffect(Effect.getEffect(Effect.POISON).setAmplifier(1).setDuration(11 * 20)).addRelative(ItemID.SUSPICIOUS_STEW.getIdentifier(), 4));

    @PowerNukkitOnly
    public static final Food suspicious_stew_saturation = registerDefaultFood(new FoodEffectiveInBow(6, 7.2F)
            .addEffect(Effect.getEffect(Effect.SATURATION).setAmplifier(1).setDuration(7)).addRelative(ItemID.SUSPICIOUS_STEW.getIdentifier(), 6));

    @PowerNukkitOnly
    public static final Food suspicious_stew_fire_resistance = registerDefaultFood(new FoodEffectiveInBow(6, 7.2F)
            .addEffect(Effect.getEffect(Effect.FIRE_RESISTANCE).setAmplifier(1).setDuration(2 * 20)).addRelative(ItemID.SUSPICIOUS_STEW.getIdentifier(), 7));

    @PowerNukkitOnly
    public static final Food suspicious_stew_regeneration = registerDefaultFood(new FoodEffectiveInBow(6, 7.2F)
            .addEffect(Effect.getEffect(Effect.REGENERATION).setAmplifier(1).setDuration(6 * 20)).addRelative(ItemID.SUSPICIOUS_STEW.getIdentifier(), 8));

    @PowerNukkitOnly
    public static final Food suspicious_stew_wither = registerDefaultFood(new FoodEffectiveInBow(6, 7.2F)
            .addEffect(Effect.getEffect(Effect.WITHER).setAmplifier(1).setDuration(6 * 20)).addRelative(ItemID.SUSPICIOUS_STEW.getIdentifier(), 9));
    
    @Deprecated @DeprecationDetails(since = "1.4.0.0-PN", reason = "Was added in Cloudburst Nukkit with another name", replaceWith = "honey_bottle")
    @PowerNukkitOnly
    public static final Food honey = registerDefaultFood(new FoodHoney(6, 1.2F).addRelative(ItemID.HONEY_BOTTLE.getIdentifier()));

    @PowerNukkitDifference(since = "1.4.0.0-PN", info = "PowerNukkit uses FoodHoney instead of FoodNormal")
    @Since("1.4.0.0-PN")
    public static final Food honey_bottle = honey;

    //Opened API for plugins
    public static Food registerFood(Food food, Plugin plugin) {
        Objects.requireNonNull(food);
        Objects.requireNonNull(plugin);
        food.relativeIDs.forEach(n -> registryCustom.put(new NodeIDMetaPlugin(n.id, n.meta, plugin), food));
        return food;
    }

    private static Food registerDefaultFood(Food food) {
        food.relativeIDs.forEach(n -> registryDefault.put(n, food));
        return food;
    }

    public static Food getByRelative(Item item) {
        Objects.requireNonNull(item);
        return getByRelative(item.getIdentifier().getIdentifier(), item.getDamage());
    }

    public static Food getByRelative(Block block) {
        Objects.requireNonNull(block);
        return getByRelative(block.getId().getIdentifier(), block.getDamage());
    }

    public static Food getByRelative(String relativeID, int meta) {
        final Food[] result = {null};
        registryCustom.forEach((n, f) -> {
            if (n.id.equals(relativeID) && n.meta == meta && n.plugin.isEnabled()) result[0] = f;
        });
        if (result[0] == null) {
            registryDefault.forEach((n, f) -> {
                if (n.id.equals(relativeID) && n.meta == meta) result[0] = f;
            });
        }
        return result[0];
    }

    protected int restoreFood = 0;
    protected float restoreSaturation = 0;
    protected final List<NodeIDMeta> relativeIDs = new ArrayList<>();

    public final boolean eatenBy(Player player) {
        PlayerEatFoodEvent event = new PlayerEatFoodEvent(player, this);
        player.getServer().getPluginManager().callEvent(event);
        if (event.isCancelled()) return false;
        return event.getFood().onEatenBy(player);
    }

    protected boolean onEatenBy(Player player) {
        player.getFoodData().addFoodLevel(this);
        return true;
    }

    public Food addRelative(String relativeID) {
        return addRelative(relativeID, 0);
    }

    public Food addRelative(String relativeID, int meta) {
        NodeIDMeta node = new NodeIDMeta(relativeID, meta);
        return addRelative(node);
    }

    private Food addRelative(NodeIDMeta node) {
        if (!relativeIDs.contains(node)) relativeIDs.add(node);
        return this;
    }

    public int getRestoreFood() {
        return restoreFood;
    }

    public Food setRestoreFood(int restoreFood) {
        this.restoreFood = restoreFood;
        return this;
    }

    public float getRestoreSaturation() {
        return restoreSaturation;
    }

    public Food setRestoreSaturation(float restoreSaturation) {
        this.restoreSaturation = restoreSaturation;
        return this;
    }
    
    @PowerNukkitOnly
    @Since("1.5.1.0-PN")
    protected int eatingTick = 31;
    
    @PowerNukkitOnly
    @Since("1.5.1.0-PN")
    public int getEatingTick() {
        return eatingTick;
    }
    
    @PowerNukkitOnly
    @Since("1.5.1.0-PN")
    public Food setEatingTick(int eatingTick) {
        this.eatingTick = eatingTick;
        return this;
    }
    
    static class NodeIDMeta {
        final String id;
        final int meta;

        NodeIDMeta(String id, int meta) {
            this.id = id;
            this.meta = meta;
        }
    }

    static class NodeIDMetaPlugin extends NodeIDMeta {
        final Plugin plugin;

        NodeIDMetaPlugin(String id, int meta, Plugin plugin) {
            super(id, meta);
            this.plugin = plugin;
        }
    }
}
