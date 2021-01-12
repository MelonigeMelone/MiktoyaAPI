package de.melonigemelone.miktoyaapi.api.coinssysteme.economy;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;

public class EconomyAPI {

    public static EconomyData getEconomyData(String uuid) {
        return MiktoyaAPI.getEconomyMySQL().get(uuid);
    }

    //TODO: BalanceTop
}
