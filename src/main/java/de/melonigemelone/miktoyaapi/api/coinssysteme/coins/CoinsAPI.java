package de.melonigemelone.miktoyaapi.api.coinssysteme.coins;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;

public class CoinsAPI {

    public static CoinsData getCoinsData(String uuid) {
        return MiktoyaAPI.getCoinsMySQL().get(uuid);
    }
}
