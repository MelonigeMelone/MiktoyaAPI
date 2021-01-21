package de.melonigemelone.miktoyaapi.api.scoreboard;

import de.melonigemelone.miktoyaapi.api.languagesystem.Language;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerData;
import de.melonigemelone.miktoyaapi.api.playerdata.PlayerDataAPI;
import de.melonigemelone.miktoyaapi.api.vault.groups.Group;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.List;
import java.util.Set;

public class ScoreBoardAPI {

    public static Scoreboard scoreboard;
    public static ScoreBoardData scoreBoardData;
    public static  Objective obj;

    public ScoreBoardAPI() {
        scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        if(scoreboard.getObjective("aaa") != null) {
            obj = scoreboard.getObjective("aaa");
            obj.unregister();
        }
    }

    public Team registerTeam(Group group) {
        Team team;
        if(scoreboard.getTeam(group.getTabRank()) == null) {
            team = scoreboard.registerNewTeam(group.getTabRank());
        } else {
            team = scoreboard.getTeam(group.getTabRank());
        }

        team.setPrefix(group.getTabPrefix());
        team.setSuffix(group.getTabSuffix());

        return team;
    }

    public static void sendScoreBoardToPlayer(PlayerData playerData) {
        Player p = playerData.getPlayer();

        if(isScoreBoardEnabled()) {
            if (scoreboard.getObjective("aaa") == null) {
                obj = scoreboard.registerNewObjective("aaa", "bbb");
            } else {
                obj = scoreboard.getObjective("aaa");
            }

            obj.setDisplayName(scoreBoardData.getDisplayName());
            obj.setDisplaySlot(DisplaySlot.SIDEBAR);

            Set<String> entries;

            entries = scoreboard.getEntries();

            for(String entry : entries)
            {
                scoreboard.resetScores(entry);
            }

            List<String> lines;
            if(playerData.getLanguage().equals(Language.ENGLISCH)) {
                lines = scoreBoardData.getLinesEnglisch();
            } else {
                lines = scoreBoardData.getLinesGerman();
            }

            int maxLine = lines.size();
            for (String line : lines) {
                setScore(obj, maxLine, PlaceholderAPI.setPlaceholders(p, line));
                maxLine--;
            }

        }

        p.setScoreboard(scoreboard);
    }

    public static void sendScoreBoardToPlayer(Player p) {
        PlayerData playerData = PlayerDataAPI.getPlayerDataFromUUIDFromOlinePlayers(p.getUniqueId().toString());
        sendScoreBoardToPlayer(playerData);

    }

    public static void updateScoreBoard(Player p) {
        if(isScoreBoardEnabled()) {
            sendScoreBoardToPlayer(p);
        }
    }

    public static void updateScoreBoard(PlayerData playerData) {
        if(isScoreBoardEnabled()) {
            sendScoreBoardToPlayer(playerData);
        }
    }

    public static void updateScoreBoard() {
        if(isScoreBoardEnabled()) {
            for (PlayerData playerData : PlayerDataAPI.getPlayerDataHashMapWithUUID().values()) {
                sendScoreBoardToPlayer(playerData);
            }
        }
    }

    public static void setScore(Objective objective, int lineNumber, String line) {
        Score score = objective.getScore(line);
        score.setScore(lineNumber);
    }

    public static void setScoreBoardData(ScoreBoardData data) {
        scoreBoardData = data;
    }

    public static boolean isScoreBoardEnabled() {
        return scoreBoardData != null;
    }


}
