package de.melonigemelone.miktoyaapi.api.coinssysteme.economy;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.lib.database.mysql.Callback;

public class EconomyAPI {

    public static EconomyData getEconomyData(String uuid) {
        return MiktoyaAPI.getEconomyMySQL().get(uuid);
    }

    //TODO: BalanceTop
}
