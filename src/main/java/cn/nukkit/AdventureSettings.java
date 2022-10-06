package cn.nukkit;

import cn.nukkit.api.PowerNukkitDifference;
import cn.nukkit.network.protocol.AdventureSettingsPacket;
import cn.nukkit.network.protocol.Protocol;
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
        if (this.player.getProtocolVersion() >= Protocol.V1_19_30.version()) {
            final UpdateAbilitiesPacket updateAbilitiesPacket = new UpdateAbilitiesPacket();
            updateAbilitiesPacket.setUniqueEntityId(this.player.getId());
            updateAbilitiesPacket.setCommandPermission(this.player.isOp() ? AdventureSettings.PERMISSION_OPERATOR : AdventureSettings.PERMISSION_NORMAL);
            updateAbilitiesPacket.setPlayerPermission(this.player.isOp() ? Player.PERMISSION_OPERATOR : Player.PERMISSION_MEMBER);

            final AbilityLayer abilityLayer = new AbilityLayer();
            abilityLayer.setLayerType(AbilityLayer.Type.BASE);
            abilityLayer.getAbilitiesSet().addAll(Arrays.asList(Ability.values()));

            for (Ability ability : Ability.values()) {
                if (ability.equals(Ability.MAY_FLY) && !this.get(Type.ALLOW_FLIGHT)) {
                    continue;
                }

                if (ability.equals(Ability.NO_CLIP) && !this.get(Type.NO_CLIP)) {
                    continue;
                }

                if (ability.equals(Ability.FLYING) && !this.get(Type.FLYING)) {
                    continue;
                }

                if (ability.equals(Ability.MUTED) && !this.get(Type.MUTED)) {
                    continue;
                }

                if (ability.equals(Ability.OPERATOR_COMMANDS) && !this.get(Type.OPERATOR)) {
                    continue;
                }

                if (ability.equals(Ability.TELEPORT) && !this.get(Type.TELEPORT)) {
                    continue;
                }

                abilityLayer.getAbilityValues().add(ability);
            }

            abilityLayer.getAbilityValues().add(Ability.WALK_SPEED);
            abilityLayer.getAbilityValues().add(Ability.FLY_SPEED);
            abilityLayer.setWalkSpeed(0.05f);
            abilityLayer.setFlySpeed(0.1f);

            updateAbilitiesPacket.getAbilityLayers().add(abilityLayer);

            final UpdateAdventureSettingsPacket updateAdventureSettingsPacket = new UpdateAdventureSettingsPacket();
            updateAdventureSettingsPacket.noPvM = false;
            updateAdventureSettingsPacket.noMvP = false;
            updateAdventureSettingsPacket.immutableWorld = this.get(Type.WORLD_IMMUTABLE);
            updateAdventureSettingsPacket.showNameTags = false;
            updateAdventureSettingsPacket.autoJump = this.get(Type.AUTO_JUMP);

            this.player.dataPacket(updateAbilitiesPacket);
            this.player.dataPacket(updateAdventureSettingsPacket);
        } else {
            AdventureSettingsPacket pk = new AdventureSettingsPacket();
            for (Type t : Type.values()) {
                pk.setFlag(t.getId(), get(t));
            }

            pk.commandPermission = (player.isOp() ? AdventureSettingsPacket.PERMISSION_OPERATOR : AdventureSettingsPacket.PERMISSION_NORMAL);
            pk.playerPermission = (player.isOp() && !player.isSpectator() ? Player.PERMISSION_OPERATOR : Player.PERMISSION_MEMBER);
            pk.entityUniqueId = player.getId();

            Server.broadcastPacket(player.getViewers().values(), pk);
            player.dataPacket(pk);

            player.resetInAirTicks();
        }
    }

    public enum Type {
        WORLD_IMMUTABLE(AdventureSettingsPacket.WORLD_IMMUTABLE, false),
        AUTO_JUMP(AdventureSettingsPacket.AUTO_JUMP, true),
        ALLOW_FLIGHT(AdventureSettingsPacket.ALLOW_FLIGHT, false),
        NO_CLIP(AdventureSettingsPacket.NO_CLIP, false),
        WORLD_BUILDER(AdventureSettingsPacket.WORLD_BUILDER, true),
        FLYING(AdventureSettingsPacket.FLYING, false),
        MUTED(AdventureSettingsPacket.MUTED, false),
        BUILD_AND_MINE(AdventureSettingsPacket.BUILD_AND_MINE, true),
        DOORS_AND_SWITCHED(AdventureSettingsPacket.DOORS_AND_SWITCHES, true),
        OPEN_CONTAINERS(AdventureSettingsPacket.OPEN_CONTAINERS, true),
        ATTACK_PLAYERS(AdventureSettingsPacket.ATTACK_PLAYERS, true),
        ATTACK_MOBS(AdventureSettingsPacket.ATTACK_MOBS, true),
        OPERATOR(AdventureSettingsPacket.OPERATOR, false),
        TELEPORT(AdventureSettingsPacket.TELEPORT, false);

        private final int id;
        private final boolean defaultValue;

        Type(int id, boolean defaultValue) {
            this.id = id;
            this.defaultValue = defaultValue;
        }

        public int getId() {
            return id;
        }

        public boolean getDefaultValue() {
            return this.defaultValue;
        }
    }
}
