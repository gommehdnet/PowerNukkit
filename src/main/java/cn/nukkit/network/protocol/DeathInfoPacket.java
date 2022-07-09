package cn.nukkit.network.protocol;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class DeathInfoPacket extends DataPacket {

    public String causeAttackName;
    public List<String> messageList = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.DEATH_INFO_PACKET;
    }

    @Override
    public void decode() {
        this.causeAttackName = this.getString();

        final int messagesLength = (int) this.getUnsignedVarInt();

        for (int i = 0; i < messagesLength; i++) {
            this.messageList.add(this.getString());
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putString(this.causeAttackName);
        this.putUnsignedVarInt(this.messageList.size());

        for (String message : this.messageList) {
            this.putString(message);
        }
    }
}