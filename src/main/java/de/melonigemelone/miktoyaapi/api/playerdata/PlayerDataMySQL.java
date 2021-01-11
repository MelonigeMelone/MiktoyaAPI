package de.melonigemelone.miktoyaapi.api.playerdata;

import de.melonigemelone.miktoyaapi.api.languagesystem.Language;
import de.melonigemelone.miktoyaapi.lib.database.mysql.MySQL;
import de.melonigemelone.miktoyaapi.mysql.MySQLValues;

import java.util.List;

public class PlayerDataMySQL extends MySQL {

    //Connect with Database and create tables
    public PlayerDataMySQL() {
        super(MySQLValues.HOST.getValue(), MySQLValues.PORT.getValue(), MySQLValues.DATABASE.getValue(), MySQLValues.USER.getValue(), MySQLValues.PASSWORD.getValue());
    }

    //Check if PlayerData with name exists in database
    public boolean existsPlayerDataWithName(String name) {
        return existsData("playerdata",
                "name  = '" + name.toLowerCase() + "'");

    }

    //Check if PlayerData with uuid exists in database
    public boolean existsPlayerDataWithUUID(String uuid) {
        return existsData("playerdata",
                "uuid  = '" + uuid + "'");

    }

    //Update PlayerData Language
    public void updateLanguage(PlayerData playerData) {
        update("playerdata",
                "language = '" + playerData.getLanguage().name() + "'",
                "uuid = '" + playerData.getUuid() + "'");
    }

    //Load PlayerData From DataBase with only the UUID
    public PlayerData getDataFromUUID(String uuid) {
        PlayerData playerData = new PlayerData(uuid, "");
        List<Object> results = get("playerdata",
                "uuid = '" + uuid + "'",
                new String[]{"language", "currentlyOnline", "lastTimeJoined", "lastTimeOnline", "onlineTime", "name"});

        playerData.setLanguage(Language.valueOf(results.get(0).toString()));
        playerData.setCurrentlyOnline(Boolean.parseBoolean(results.get(1).toString()));
        playerData.setLastTimeJoined(Long.parseLong(results.get(2).toString()));
        playerData.setLastTimeOnline(Long.parseLong(results.get(3).toString()));
        playerData.setOnlineTime(Long.parseLong(results.get(4).toString()));
        playerData.setName(results.get(5).toString());
        return playerData;
    }

    //Load PlayerData From DataBase with only the Name
    public PlayerData getDataFromName(String name) {
        PlayerData playerData = new PlayerData("", name);
        List<Object> results = get("playerdata",
                "name = '" + playerData.getName() + "'",
                new String[]{"language", "currentlyOnline", "lastTimeJoined", "lastTimeOnline", "onlineTime", "uuid"});

        playerData.setLanguage(Language.valueOf(results.get(0).toString()));
        playerData.setCurrentlyOnline(Boolean.parseBoolean(results.get(1).toString()));
        playerData.setLastTimeJoined(Long.parseLong(results.get(2).toString()));
        playerData.setLastTimeOnline(Long.parseLong(results.get(3).toString()));
        playerData.setOnlineTime(Long.parseLong(results.get(4).toString()));
        playerData.setUuid(results.get(5).toString());
        return playerData;
    }
}
