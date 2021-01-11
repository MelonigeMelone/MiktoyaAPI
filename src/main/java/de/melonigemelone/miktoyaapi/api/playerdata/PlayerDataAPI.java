package de.melonigemelone.miktoyaapi.api.playerdata;


import de.melonigemelone.miktoyaapi.MiktoyaAPI;

import java.util.HashMap;

public class PlayerDataAPI {

    private static HashMap<String, PlayerData> playerDataHashMapWithUUID = new HashMap<>();
    private static HashMap<String, PlayerData> playerDataHashMapWithName = new HashMap<>();


    //Gibt die PlayerData vom dem Spieler anhand der UUID zurück (wenn nicht lokal dann von der DB)
    public static PlayerData getPlayerDataFromUUID(String uuid) {
        PlayerDataMySQL playerDataMySQL = MiktoyaAPI.getPlayerDataMySQL();

        if(playerDataHashMapWithUUID.containsKey(uuid)) {
            return playerDataHashMapWithUUID.get(uuid);
        } else {
            return playerDataMySQL.getDataFromUUID(uuid);
        }
    }

    //Gibt die PlayerData vom dem Spieler anhand von dem Namen zurück (wenn nicht lokal dann von der DB)
    public static PlayerData getPlayerDataFromName(String name) {
        PlayerDataMySQL playerDataMySQL = MiktoyaAPI.getPlayerDataMySQL();

        if(playerDataHashMapWithName.containsKey(name.toLowerCase())) {
            return playerDataHashMapWithName.get(name.toLowerCase());
        } else {
            return playerDataMySQL.getDataFromName(name);
        }
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
