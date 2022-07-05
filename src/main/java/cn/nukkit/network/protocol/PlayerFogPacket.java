package cn.nukkit.network.protocol;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class PlayerFogPacket extends DataPacket {

    public final List<String> fogStack = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.PLAYER_FOG_PACKET;
    }

    @Override
    public void decode() {
        long fogStackLength = this.getUnsignedVarInt();

        for (int i = 0; i < fogStackLength; i++) {
            String fogId = this.getString();

            this.fogStack.add(fogId);
        }
    }

    @Override
    public void encode() {
        this.putUnsignedVarInt(this.fogStack.size());

        for (String fogId : this.fogStack) {
            this.putString(fogId);
        }
    }
}