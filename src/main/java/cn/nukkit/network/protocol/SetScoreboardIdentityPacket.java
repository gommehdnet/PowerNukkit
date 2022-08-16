package cn.nukkit.network.protocol;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.Value;

import java.util.List;
import java.util.UUID;

/**
 * @author Kaooot
 * @version 1.0
 */
public class SetScoreboardIdentityPacket extends DataPacket {

    public Action action;
    public List<Entry> entries = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.SET_SCOREBOARD_IDENTITY_PACKET;
    }

    @Override
    public void decode() {
        this.action = Action.values()[this.getByte()];

        final int entriesLength = (int) this.getUnsignedVarInt();

        for (int i = 0; i < entriesLength; i++) {
            this.entries.add(new Entry(this.getLLong(), this.getUUID()));
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putByte((byte) this.action.ordinal());

        for (Entry entry : this.entries) {
            this.putLLong(entry.scoreboardId);
            this.putUUID(entry.uuid);
        }
    }

    public enum Action {
        ADD,
        REMOVE
    }

    @Value
    public static class Entry {
        long scoreboardId;
        UUID uuid;
    }
}