package cn.nukkit;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.network.protocol.UpdateAbilitiesPacket;
import cn.nukkit.network.protocol.UpdateAdventureSettingsPacket;
import cn.nukkit.network.protocol.types.Ability;
import cn.nukkit.network.protocol.types.AbilityLayer;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/**
 * @author MagicDroidX (Nukkit Project)
 */
public class AdventureSettings implements Cloneable {

    public static final int PERMISSION_NORMAL = 0;
    public static final int PERMISSION_OPERATOR = 1;
    public static final int PERMISSION_HOST = 2;
    public static final int PERMISSION_AUTOMATION = 3;
    public static final int PERMISSION_ADMIN = 4;

    private Map<Type, Boolean> values = new EnumMap<>(Type.class);

    private Player player;

    public AdventureSettings(Player player) {
        this.player = player;
    }

    public AdventureSettings clone(Player newPlayer) {
        try {
            AdventureSettings settings = (AdventureSettings) super.clone();
            settings.player = newPlayer;
            return settings;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public AdventureSettings set(Type type, boolean value) {
        this.values.put(type, value);
        return this;
    }

    public boolean get(Type type) {
        Boolean value = this.values.get(type);

        return value == null ? type.getDefaultValue() : value;
    }

    @PowerNukkitDifference(
            info = "Players in spectator mode will be flagged as member even if they are OP due to a client-side limitation",
            since = "1.3.1.2-PN")
    public void update() {
        final UpdateAbilitiesPacket updateAbilitiesPacket = new UpdateAbilitiesPacket();
        updateAbilitiesPacket.setUniqueEntityId(this.player.getId());
        updateAbilitiesPacket.setCommandPermission(this.player.isOp() ? AdventureSettings.PERMISSION_OPERATOR : AdventureSettings.PERMISSION_NORMAL);
        updateAbilitiesPacket.setPlayerPermission(this.player.isOp() ? Player.PERMISSION_OPERATOR : Player.PERMISSION_MEMBER);

        final AbilityLayer abilityLayer = new AbilityLayer();
        abilityLayer.setLayerType(AbilityLayer.Type.BASE);
        abilityLayer.getAbilitiesSet().addAll(Arrays.asList(Ability.values()));

        for (Type type : Type.values()) {
            if (type.getAbility() != null && this.get(type)) {
                abilityLayer.getAbilityValues().add(type.getAbility());
            }
        }

        abilityLayer.getAbilityValues().add(Ability.WALK_SPEED);
        abilityLayer.getAbilityValues().add(Ability.FLY_SPEED);
        abilityLayer.setWalkSpeed(0.1f);
        abilityLayer.setFlySpeed(0.05f);

        updateAbilitiesPacket.getAbilityLayers().add(abilityLayer);

        final UpdateAdventureSettingsPacket updateAdventureSettingsPacket = new UpdateAdventureSettingsPacket();
        updateAdventureSettingsPacket.noPvM = false;
        updateAdventureSettingsPacket.noMvP = false;
        updateAdventureSettingsPacket.immutableWorld = this.get(Type.WORLD_IMMUTABLE);
        updateAdventureSettingsPacket.showNameTags = false;
        updateAdventureSettingsPacket.autoJump = this.get(Type.AUTO_JUMP);

        this.player.dataPacket(updateAbilitiesPacket);
        this.player.dataPacket(updateAdventureSettingsPacket);
    }

    public enum Type {
        WORLD_IMMUTABLE(false),
        NO_PVM(false),
        NO_MVP(Ability.INVULNERABLE, false),
        SHOW_NAME_TAGS(false),
        AUTO_JUMP(true),
        MAY_FLY(Ability.MAY_FLY, false),
        NO_CLIP(Ability.NO_CLIP, false),
        WORLD_BUILDER(Ability.WORLD_BUILDER, false),
        FLYING(Ability.FLYING, false),
        MUTED(Ability.MUTED, false),
        MINE(Ability.MINE, true),
        DOORS_AND_SWITCHES(Ability.DOORS_AND_SWITCHES, true),
        OPEN_CONTAINERS(Ability.OPEN_CONTAINERS, true),
        ATTACK_PLAYERS(Ability.ATTACK_PLAYERS, true),
        ATTACK_MOBS(Ability.ATTACK_MOBS, true),
        OPERATOR(Ability.OPERATOR_COMMANDS, false),
        TELEPORT(Ability.TELEPORT, false),
        BUILD(Ability.BUILD, true);

        private final Ability ability;
        private final boolean defaultValue;

        Type(boolean defaultValue) {
            this.ability = null;
            this.defaultValue = defaultValue;
        }

        Type(Ability ability, boolean defaultValue) {
            this.ability = ability;
            this.defaultValue = defaultValue;
        }

        public Ability getAbility() {
            return this.ability;
        }

        public boolean getDefaultValue() {
            return this.defaultValue;
        }
    }
}
