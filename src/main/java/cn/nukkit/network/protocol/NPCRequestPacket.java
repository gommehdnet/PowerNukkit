package cn.nukkit.network.protocol;

import cn.nukkit.api.PowerNukkitOnly;
import cn.nukkit.api.Since;
import lombok.ToString;

@ToString
public class NPCRequestPacket extends DataPacket {

    @PowerNukkitOnly
    @Since("1.6.0.1-PN")
    public static final byte NETWORK_ID = ProtocolInfo.NPC_REQUEST_PACKET;

    @Since("1.4.0.0-PN")
    public long entityRuntimeId;

    @Since("1.4.0.0-PN")
    public RequestType requestType;

    @Since("1.4.0.0-PN")
    public String command;

    @Since("1.4.0.0-PN")
    public int actionType;

    @Since("1.6.0.0-PN")
    public String sceneName;

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public long getRequestedEntityRuntimeId() {
        return entityRuntimeId;
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public void setRequestedEntityRuntimeId(long entityRuntimeId) {
        this.entityRuntimeId = entityRuntimeId;
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public RequestType getRequestType() {
        return requestType;
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public String getCommand() {
        return command;
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public void setCommand(String commandString) {
        this.command = commandString;
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public int getActionType() {
        return actionType;
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public String getSceneName() {
        return sceneName;
    }

    @PowerNukkitOnly
    @Since("1.5.2.0-PN")
    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    @Since("1.4.0.0-PN")
    public enum RequestType {
        @Since("1.4.0.0-PN") SET_ACTION,
        @Since("1.4.0.0-PN") EXECUTE_COMMAND_ACTION,
        @Since("1.4.0.0-PN") EXECUTE_CLOSING_COMMANDS,
        @Since("1.4.0.0-PN") SET_NAME,
        @Since("1.4.0.0-PN") SET_SKIN,
        @Since("1.4.0.0-PN") SET_INTERACTION_TEXT,
        @Since("1.4.0.0-PN") EXECUTE_OPENING_COMMANDS
    }

    @Override
    public byte pid() {
        return NETWORK_ID;
    }

    @Override
    public void decode() {
        this.entityRuntimeId = super.getEntityRuntimeId();
        this.requestType = RequestType.values()[this.getByte()];
        this.command = this.getString();
        this.actionType = this.getByte();
        this.sceneName = this.getString();
    }

    @Override
    public void encode() {
        this.reset();
        this.putEntityRuntimeId(this.entityRuntimeId);
        this.putByte((byte) requestType.ordinal());
        this.putString(this.command);
        this.putByte((byte) this.actionType);
        this.putString(this.sceneName);
    }
}
