package de.melonigemelone.miktoyaapi.api.playerdata;


import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.api.scoreboard.ScoreBoardAPI;
import de.melonigemelone.miktoyaapi.api.vanish.VanishAPI;
import de.melonigemelone.miktoyaapi.api.vault.groups.GroupAPI;
import de.melonigemelone.miktoyaapi.repository.lib.database.mysql.Callback;
import de.melonigemelone.miktoyaapi.repository.lib.minecraft.messagebuilder.tablist.TablistAPI;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class PlayerDataAPI {

    private static HashMap<String, PlayerData> playerDataHashMapWithUUID = new HashMap<>();
    private static HashMap<String, PlayerData> playerDataHashMapWithName = new HashMap<>();

    public static void playerJoins(Player p) {
        String uuid = p.getUniqueId().toString();

        MiktoyaAPI.getPlayerDataMySQL().getDataFromUUID(uuid, playerData -> {
            playerData.setPlayer(p);
            playerDataHashMapWithUUID.put(uuid, playerData);
            playerDataHashMapWithName.put(playerData.getName(), playerData);

            GroupAPI.getGroupFromPlayer(p).addPlayerToTeam(p);
            ScoreBoardAPI.sendScoreBoardToPlayer(p);
            TablistAPI.send(p);

            if(playerData.isVanish()) {
                MiktoyaAPI.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(MiktoyaAPI.getInstance(), () -> {
                    VanishAPI.addPlayerToVanish(playerData);
                });
            }

            if(!playerData.isSelectedLanguage()) {
                MiktoyaAPI.getInstance().getServer().getScheduler().scheduleSyncDelayedTask(MiktoyaAPI.getInstance(), () -> {

                });
            }
        });
    }

    public static void loadPlayerDataFromDataBase(String uuid) {
        MiktoyaAPI.getPlayerDataMySQL().getDataFromUUID(uuid, playerData -> {
            playerDataHashMapWithUUID.put(uuid, playerData);
            playerDataHashMapWithName.put(playerData.getName(), playerData);
        });

    }

    public static void removePlayerDataFromLocalStorage(String uuid) {
            PlayerData playerData = playerDataHashMapWithUUID.get(uuid);
            playerDataHashMapWithUUID.remove(uuid);
            playerDataHashMapWithName.remove(playerData.getName());


    }


    public static PlayerData getPlayerDataFromUUIDFromOlinePlayers(String uuid) {
        return playerDataHashMapWithUUID.get(uuid);
    }

    public static void getPlayerDataFromUUIDFromDatabase(String uuid, Callback<PlayerData> callback) {
        MiktoyaAPI.getPlayerDataMySQL().getDataFromUUID(uuid, callback);
    }

    public static PlayerData getPlayerDataFromNameFromOnlinePlayers(String name) {
        return playerDataHashMapWithName.get(name.toLowerCase());
    }

    //Gibt die PlayerData vom dem Spieler anhand von dem Namen zurück (wenn nicht lokal dann von der DB)
    public static void getPlayerDataFromNameFromDataBase(String name, Callback<PlayerData> callback) {
        MiktoyaAPI.getPlayerDataMySQL().getDataFromName(name, callback);
    }

    //Überprüft ob der Spieler mit der UUID online ist
    public static boolean isPlayerOnlineWithUUID(String uuid) {
        return playerDataHashMapWithUUID.containsKey(uuid);
    }

    //Überprüft ob der Spieler mit der UUID online ist
    public static boolean isPlayerOnlineWithName(String name) {
        return playerDataHashMapWithName.containsKey(name);
    }

    public static HashMap<String, PlayerData> getPlayerDataHashMapWithName() {
        return playerDataHashMapWithName;
    }

    public static HashMap<String, PlayerData> getPlayerDataHashMapWithUUID() {
        return playerDataHashMapWithUUID;
    }
}
