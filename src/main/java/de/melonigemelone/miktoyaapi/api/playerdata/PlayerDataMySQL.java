package de.melonigemelone.miktoyaapi.api.playerdata;

import de.melonigemelone.miktoyaapi.api.languagesystem.Language;
import de.melonigemelone.miktoyaapi.lib.database.mysql.Callback;
import de.melonigemelone.miktoyaapi.lib.database.mysql.MySQL;
import de.melonigemelone.miktoyaapi.mysql.MySQLValues;

import java.util.List;

public class PlayerDataMySQL extends MySQL {

    //Verbindet sich mit der Datenbank und erstellt die Tabellen
    public PlayerDataMySQL() {
        super(MySQLValues.HOST.getValue(), MySQLValues.PORT.getValue(), MySQLValues.DATABASE.getValue(), MySQLValues.USER.getValue(), MySQLValues.PASSWORD.getValue());
    }

    //Überpürft ob es in der Datenbank eines Spieler mit der UUID gibt
    public void existsPlayerWithUUID(String uuid, Callback<Boolean> callback) {
        existsData("playerdata",
                "uuid  = '" + uuid + "'", callback);

    }

    //Überpürft ob es in der Datenbank eines Spieler mit dem Namen gibt
    public void existsPlayerWithName(String name, Callback<Boolean> callback) {
        existsData("playerdata",
                "name  = '" + name.toLowerCase() + "'", callback);
    }

    //Check if PlayerData exists with UUID
    public void existsPlayerWithIP(String ip, Callback<Boolean> callback) {
        existsData("playerdata",
                "ip  = '" + ip + "'", callback);

    }

    //Get Language From Player
    public void getLanguage(PlayerData playerData, Callback<Language> callback) {
        get("playerdata",
                "uuid = '" + playerData.getUuid() + "'",
                new String[]{"language"}, result -> {
                    callback.taskDone(Language.valueOf(result.get(0).toString()));
                });
    }

    //Load PlayerData From DataBase with only the UUID
    public void getDataFromUUID(String uuid, Callback<PlayerData> callback) {

        get("playerdata",
                "uuid = '" + uuid + "'",
                new String[]{"language", "currentlyOnline", "lastTimeJoined", "lastTimeOnline", "onlineTime", "name", "ip", "firstJoin", "currentServerName"}, result -> {
                    PlayerData playerData = new PlayerData(uuid, "");

                    playerData.setLanguage(Language.valueOf(result.get(0).toString()));
                    playerData.setCurrentlyOnline(Boolean.parseBoolean(result.get(1).toString()));
                    playerData.setLastTimeJoined(Long.parseLong(result.get(2).toString()));
                    playerData.setLastTimeOnline(Long.parseLong(result.get(3).toString()));
                    playerData.setOnlineTime(Long.parseLong(result.get(4).toString()));
                    playerData.setName(result.get(5).toString());
                    playerData.setIp(result.get(6).toString());
                    playerData.setFirstJoin(Long.parseLong(result.get(7).toString()));
                    playerData.setCurrentServerName(result.get(8).toString());

                    callback.taskDone(playerData);
                });

    }

    //Load PlayerData From DataBase with only the Name
    public void getDataFromName(String name, Callback<PlayerData> callback) {
        get("playerdata",
                "name = '" + name + "'",
                new String[]{"language", "currentlyOnline", "lastTimeJoined", "lastTimeOnline", "onlineTime", "uuid", "ip", "firstJoin", "currentServerName"}, result -> {
                    PlayerData playerData = new PlayerData("", name);
                    playerData.setLanguage(Language.valueOf(result.get(0).toString()));
                    playerData.setCurrentlyOnline(Boolean.parseBoolean(result.get(1).toString()));
                    playerData.setLastTimeJoined(Long.parseLong(result.get(2).toString()));
                    playerData.setLastTimeOnline(Long.parseLong(result.get(3).toString()));
                    playerData.setOnlineTime(Long.parseLong(result.get(4).toString()));
                    playerData.setUuid(result.get(5).toString());
                    playerData.setIp(result.get(6).toString());
                    playerData.setFirstJoin(Long.parseLong(result.get(7).toString()));
                    playerData.setCurrentServerName(result.get(8).toString());

                    callback.taskDone(playerData);
                } );

    }

    public void resetCurrentOnline() {
        update("playerdata",
                "currentlyOnline = false");
    }
}
