package de.melonigemelone.miktoyaapi.api.coinssysteme.economy;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.repository.lib.database.mysql.Callback;

import java.util.HashMap;

public class EconomyAPI {

    public static HashMap<String, EconomyData> economyDataHashMap = new HashMap<>();

    public static void loadEconomyDataFromDataBase(String uuid) {
        MiktoyaAPI.getEconomyMySQL().get(uuid, economyData -> {
            economyDataHashMap.put(uuid, economyData);
        });
    }

    public static void removeEconomyDataFromLocalStorgae(String uuid) {
        economyDataHashMap.remove(uuid);
    }

    //Gibt die CoinsData eines Online-Spieler zurück
    public static EconomyData getEconomyDataFromOnlinePlayer(String uuid) {
        return economyDataHashMap.get(uuid);
    }

    //Gibt die CoinsData eines Offline-Spieler zurück
    public static void getEconomyDataFromOfflinePlayer(String uuid, Callback<EconomyData> callback) {
        MiktoyaAPI.getEconomyMySQL().get(uuid, callback);
    }

    //Gibt die CoinsData eines Offline-Spieler zurück
    public static EconomyData getEconomyDataFromOfflinePlayerSync(String uuid) {
        return MiktoyaAPI.getEconomyMySQL().getSync(uuid);
    }



    //TODO: BalanceTop
}
