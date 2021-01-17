package de.melonigemelone.miktoyaapi.api.coinssysteme.coins;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.repository.lib.database.mysql.Callback;

public class CoinsAPI {

    public static void getCoinsData(String uuid, Callback<CoinsData> callback) {
        MiktoyaAPI.getCoinsMySQL().get(uuid, callback);
    }

    public static CoinsData getCoinsDataSync(String uuid) {
        return MiktoyaAPI.getCoinsMySQL().getSync(uuid);
    }
}
