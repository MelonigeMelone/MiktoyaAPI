package de.melonigemelone.miktoyaapi.api.playerdata;


import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.repository.lib.database.mysql.Callback;

import java.util.HashMap;

public class PlayerDataAPI {

    private static HashMap<String, PlayerData> playerDataHashMapWithUUID = new HashMap<>();
    private static HashMap<String, PlayerData> playerDataHashMapWithName = new HashMap<>();


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

}
