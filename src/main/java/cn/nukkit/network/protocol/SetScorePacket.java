package cn.nukkit.network.protocol;

import cn.nukkit.network.protocol.types.ScoreAction;
import cn.nukkit.network.protocol.types.ScoreEntry;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.List;

/**
 * @author Kaooot
 * @version 1.0
 */
public class SetScorePacket extends DataPacket {

    public ScoreAction action;
    public List<ScoreEntry> entries = new ObjectArrayList<>();

    @Override
    public byte pid() {
        return ProtocolInfo.SET_SCORE_PACKET;
    }

    @Override
    public void decode() {
        this.action = ScoreAction.values()[this.getByte()];

        final int entriesLength = (int) this.getUnsignedVarInt();

        for (int i = 0; i < entriesLength; i++) {
            final long scoreboardId = this.getVarLong();
            final String objectiveName = this.getString();
            final int score = this.getLInt();

            ScoreEntry.ScoreEntryType type = ScoreEntry.ScoreEntryType.INVALID;
            long entityUniqueId = -1;
            String customName = null;

            if (this.action.equals(ScoreAction.CHANGE)) {
                type = ScoreEntry.ScoreEntryType.values()[this.getByte()];

                if (type.equals(ScoreEntry.ScoreEntryType.PLAYER) || type.equals(ScoreEntry.ScoreEntryType.ENTITY)) {
                    entityUniqueId = this.getVarLong();
                }

                if (type.equals(ScoreEntry.ScoreEntryType.FAKE_PLAYER)) {
                    customName = this.getString();
                }
            }

            this.entries.add(new ScoreEntry(scoreboardId, objectiveName, score, type, entityUniqueId, customName));
        }
    }

    @Override
    public void encode() {
        this.reset();
        this.putByte((byte) this.action.ordinal());
        this.putUnsignedVarInt(this.entries.size());

        for (ScoreEntry entry : this.entries) {
            this.putVarLong(entry.getScoreboardId());
            this.putString(entry.getObjectiveName());
            this.putLInt(entry.getScore());

            if (this.action.equals(ScoreAction.CHANGE)) {
                this.putByte((byte) entry.getType().ordinal());

                if (entry.getType().equals(ScoreEntry.ScoreEntryType.PLAYER) || entry.getType().equals(ScoreEntry.ScoreEntryType.ENTITY)) {
                    this.putVarLong(entry.getEntityUniqueId());
                }

                if (entry.getType().equals(ScoreEntry.ScoreEntryType.FAKE_PLAYER)) {
                    this.putString(entry.getCustomName());
                }
            }
        }
    }
}