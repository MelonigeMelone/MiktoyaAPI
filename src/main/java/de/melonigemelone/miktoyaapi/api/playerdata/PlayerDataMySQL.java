package de.melonigemelone.miktoyaapi.api.playerdata;

import de.melonigemelone.miktoyaapi.api.languagesystem.Language;
import de.melonigemelone.miktoyaapi.repository.config.mysql.MySQLValues;
import de.melonigemelone.miktoyaapi.repository.lib.database.mysql.Callback;
import de.melonigemelone.miktoyaapi.repository.lib.database.mysql.MySQL;

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

    //Update PlayerData Entry
    public void updateVanish(PlayerData playerData) {
        update("playerdata",
                "vanish = " + playerData.isVanish(),
                "uuid = '" + playerData.getUuid() + "'");
    }

    //Update PlayerData Entry
    public void updateSelectedLanguage(PlayerData playerData) {
        update("playerdata",
                "selectedLanguage = " + playerData.isSelectedLanguage(),
                "uuid = '" + playerData.getUuid() + "'");
    }

    //Load PlayerData From DataBase with only the UUID
    public void getDataFromUUID(String uuid, Callback<PlayerData> callback) {

        get("playerdata",
                "uuid = '" + uuid + "'",
                new String[]{"language", "currentlyOnline", "lastTimeJoined", "lastTimeOnline", "onlineTime", "name", "ip", "firstJoin", "currentServerName", "vanish", "selectedLanguage"}, result -> {
                    callback.taskDone(

                            new PlayerData(uuid, result.get(5).toString())
                                    .setLanguage(Language.valueOf(result.get(0).toString()))
                                    .setCurrentlyOnline(Boolean.parseBoolean(result.get(1).toString()))
                                    .setLastTimeJoined(Long.parseLong(result.get(2).toString()))
                                    .setLastTimeOnline(Long.parseLong(result.get(3).toString()))
                                    .setOnlineTime(Long.parseLong(result.get(4).toString()))
                                    .setIp(result.get(6).toString())
                                    .setFirstJoin(Long.parseLong(result.get(7).toString()))
                                    .setCurrentServerName(result.get(8).toString())
                                    .setVanish(Boolean.parseBoolean(result.get(9).toString()))
                                    .setSelectedLanguage(Boolean.parseBoolean(result.get(10).toString())));


                });

    }

    //Load PlayerData From DataBase with only the Name
    public void getDataFromName(String name, Callback<PlayerData> callback) {
        get("playerdata",
                "name = '" + name + "'",
                new String[]{"language", "currentlyOnline", "lastTimeJoined", "lastTimeOnline", "onlineTime", "uuid", "ip", "firstJoin", "currentServerName", "vanish"}, result -> {
                    callback.taskDone(

                            new PlayerData(result.get(5).toString(), name)
                                    .setLanguage(Language.valueOf(result.get(0).toString()))
                                    .setCurrentlyOnline(Boolean.parseBoolean(result.get(1).toString()))
                                    .setLastTimeJoined(Long.parseLong(result.get(2).toString()))
                                    .setLastTimeOnline(Long.parseLong(result.get(3).toString()))
                                    .setOnlineTime(Long.parseLong(result.get(4).toString()))
                                    .setIp(result.get(6).toString())
                                    .setFirstJoin(Long.parseLong(result.get(7).toString()))
                                    .setCurrentServerName(result.get(8).toString())
                                    .setVanish(Boolean.parseBoolean(result.get(9).toString())));
                });

    }

}
