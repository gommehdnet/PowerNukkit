package cn.nukkit.network.protocol;

import cn.nukkit.Server;
import cn.nukkit.api.Since;
import cn.nukkit.entity.data.EntityMetadata;
import cn.nukkit.item.Item;
import cn.nukkit.network.protocol.types.AbilityLayer;
import cn.nukkit.network.protocol.types.CommandPermission;
import cn.nukkit.network.protocol.types.PlayerAbilityHolder;
import cn.nukkit.network.protocol.types.PlayerPermission;
import cn.nukkit.utils.Binary;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

/**
 * @author MagicDroidX (Nukkit Project)
 */
@ToString
public class AddPlayerPacket extends DataPacket implements PlayerAbilityHolder {
    public static final byte NETWORK_ID = ProtocolInfo.ADD_PLAYER_PACKET;

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    public UUID uuid;
    public String username;
    public long entityUniqueId;
    public long entityRuntimeId;
    public String platformChatId = "";
    public float x;
    public float y;
    public float z;
    public float speedX;
    public float speedY;
    public float speedZ;
    public float pitch;
    public float yaw;
    public Item item;
    @Since("1.6.0.0-PN")
    public int gameType = Server.getInstance().getGamemode();
    public EntityMetadata metadata = new EntityMetadata();
    //public EntityLink links = new EntityLink[0];
    public String deviceId = "";
    public int buildPlatform = -1;

    private PlayerPermission playerPermission = PlayerPermission.MEMBER;
    private CommandPermission commandPermission = CommandPermission.ANY;
    private List<AbilityLayer> abilityLayers = new ObjectArrayList<>();

    @Override
    public void decode() {

    }

    @Override
    public void encode() {
        this.reset();
        this.putUUID(this.uuid);
        this.putString(this.username);
        this.putEntityUniqueId(this.entityUniqueId);
        this.putEntityRuntimeId(this.entityRuntimeId);
        this.putString(this.platformChatId);
        this.putVector3f(this.x, this.y, this.z);
        this.putVector3f(this.speedX, this.speedY, this.speedZ);
        this.putLFloat(this.pitch);
        this.putLFloat(this.yaw); //TODO headrot
        this.putLFloat(this.yaw);
        this.putSlot(this.item, this.protocolVersion);

        if (this.protocolVersion >= Protocol.V1_18_30.version()) {
            this.putVarInt(this.gameType);
        }

        this.put(Binary.writeMetadata(this.metadata));

        if (this.protocolVersion >= Protocol.V1_19_10.version()) {
            this.putPlayerAbilities(this);
        }

        this.putUnsignedVarInt(0); //TODO: Adventure settings
        this.putUnsignedVarInt(0);
        this.putUnsignedVarInt(0);
        this.putUnsignedVarInt(0);
        this.putUnsignedVarInt(0);
        this.putLLong(entityUniqueId);
        this.putUnsignedVarInt(0); //TODO: Entity links
        this.putString(deviceId);
        this.putLInt(buildPlatform);
    }

    @Override
    public long getUniqueEntityId() {
        return this.entityUniqueId;
    }

    @Override
    public void setUniqueEntityId(long uniqueEntityId) {
        this.entityUniqueId = uniqueEntityId;
    }

    @Override
    public PlayerPermission getPlayerPermission() {
        return this.playerPermission;
    }

    @Override
    public void setPlayerPermission(PlayerPermission playerPermission) {
        this.playerPermission = playerPermission;
    }

    @Override
    public CommandPermission getCommandPermission() {
        return this.commandPermission;
    }

    @Override
    public void setCommandPermission(CommandPermission commandPermission) {
        this.commandPermission = commandPermission;
    }

    @Override
    public List<AbilityLayer> getAbilityLayers() {
        return this.abilityLayers;
    }

    @Override
    public void setAbilityLayers(List<AbilityLayer> abilityLayers) {
        this.abilityLayers = abilityLayers;
    }
}