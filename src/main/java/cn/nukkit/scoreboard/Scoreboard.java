package cn.nukkit.scoreboard;

import cn.nukkit.Player;
import cn.nukkit.network.protocol.RemoveObjectivePacket;
import cn.nukkit.network.protocol.SetDisplayObjectivePacket;
import cn.nukkit.network.protocol.SetScorePacket;
import cn.nukkit.network.protocol.types.ScoreAction;
import cn.nukkit.network.protocol.types.ScoreEntry;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Kaooot
 * @version 1.0
 */
@Setter
@Accessors(fluent = true)
public class Scoreboard {

    private final String objectiveName = UUID.randomUUID().toString();
    private final String criteriaName = "dummy";
    private final int sortOrder = 0;
    private final String displaySlot = "sidebar";
    private final List<ScoreEntry> generalScoreEntries = new ArrayList<>();
    private final Map<UUID, List<ScoreEntry>> playerSoreEntries = new HashMap<>();

    private String title;

    public void line(int score, String line) {
        this.generalScoreEntries.add(new ScoreEntry(score, this.objectiveName, score, ScoreEntry.ScoreEntryType.FAKE_PLAYER, -1, line));
    }

    public void addLine(int score, String line, Player player) {
        this.getPlayerSoreEntries(player.getUniqueId()).add(new ScoreEntry(score, this.objectiveName, score, ScoreEntry.ScoreEntryType.FAKE_PLAYER, -1, line));

        final SetScorePacket setScorePacket = new SetScorePacket();
        setScorePacket.action = ScoreAction.CHANGE;
        setScorePacket.entries = this.getPlayerSoreEntries(player.getUniqueId()).stream().filter(scoreEntry -> scoreEntry.getScore() == score).collect(Collectors.toList());

        player.dataPacket(setScorePacket);
    }

    public void updateLine(int score, String line, Player player) {
        this.removeLine(score, player);
        this.addLine(score, line, player);
    }

    public void removeLine(int score, Player player) {
        this.getPlayerSoreEntries(player.getUniqueId()).removeIf(scoreEntry -> {
            if (scoreEntry.getScore() == score) {
                final SetScorePacket setScorePacket = new SetScorePacket();
                setScorePacket.action = ScoreAction.REMOVE;
                setScorePacket.entries = Collections.singletonList(scoreEntry);

                player.dataPacket(setScorePacket);

                return true;
            }

            return false;
        });
    }

    public void addPlayer(Player player) {
        final SetDisplayObjectivePacket setDisplayObjectivePacket = new SetDisplayObjectivePacket();
        setDisplayObjectivePacket.displaySlot = this.displaySlot;
        setDisplayObjectivePacket.objectiveName = this.objectiveName;
        setDisplayObjectivePacket.displayName = this.title;
        setDisplayObjectivePacket.criteriaName = this.criteriaName;
        setDisplayObjectivePacket.sortOrder = this.sortOrder;

        player.dataPacket(setDisplayObjectivePacket);

        final SetScorePacket setScorePacket = new SetScorePacket();
        setScorePacket.action = ScoreAction.CHANGE;
        setScorePacket.entries = this.generalScoreEntries;

        player.dataPacket(setScorePacket);

        this.playerSoreEntries.put(player.getUniqueId(), this.generalScoreEntries);
    }

    public void removePlayer(Player player) {
        final RemoveObjectivePacket packet = new RemoveObjectivePacket();
        packet.objectiveName = this.objectiveName;

        player.dataPacket(packet);

        this.playerSoreEntries.remove(player.getUniqueId());
    }

    private List<ScoreEntry> getPlayerSoreEntries(UUID uuid) {
        return this.playerSoreEntries.getOrDefault(uuid, new ObjectArrayList<>());
    }
}