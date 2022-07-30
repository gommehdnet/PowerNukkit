package cn.nukkit.network.protocol.types;

import lombok.Value;

/**
 * @author Kaooot
 * @version 1.0
 */
@Value
public class ScoreEntry {

    long scoreboardId;
    String objectiveName;
    int score;
    ScoreEntryType type;
    long entityUniqueId;
    String customName;

    public enum ScoreEntryType {
        INVALID,
        PLAYER,
        ENTITY,
        FAKE_PLAYER
    }
}