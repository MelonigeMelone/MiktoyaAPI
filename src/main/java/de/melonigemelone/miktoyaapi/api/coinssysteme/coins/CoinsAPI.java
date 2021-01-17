package de.melonigemelone.miktoyaapi.api.coinssysteme.coins;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.repository.lib.database.mysql.Callback;

import java.util.HashMap;

public class CoinsAPI {

    public static HashMap<String, CoinsData> coinsDataHashMap = new HashMap<>();

    //Lädt die CoinsData in den lokalen Speicher
    public static void loadCoinsDataFromDataBase(String uuid) {
        MiktoyaAPI.getCoinsMySQL().get(uuid, coinsData -> {
            coinsDataHashMap.put(uuid, coinsData);
        });
    }

    //Löscht die CoinsData aus dem lokalen Speicher
    public static void removeCoinsDataFromLocalStorgae(String uuid) {
        coinsDataHashMap.remove(uuid);
    }

    //Gibt die CoinsData eines Online-Spieler zurück
    public static CoinsData getCoinsDataFromOnlinePlayer(String uuid) {
        return coinsDataHashMap.get(uuid);
    }

    //Gibt die CoinsData eines Offline-Spieler asynchron zurück
    public static void getCoinsDataFromOfflinePlayer(String uuid, Callback<CoinsData> callback) {
        MiktoyaAPI.getCoinsMySQL().get(uuid, callback);
    }

    //Gibt die CoinsData eines Offline-Spieler synchron zurück
    public static CoinsData getCoinsDataFromOfflinePlayerSync(String uuid) {
        return MiktoyaAPI.getCoinsMySQL().getSync(uuid);
    }
}
