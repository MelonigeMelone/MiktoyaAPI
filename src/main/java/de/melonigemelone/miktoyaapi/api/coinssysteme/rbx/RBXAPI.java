package de.melonigemelone.miktoyaapi.api.coinssysteme.rbx;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.repository.lib.database.mysql.Callback;

public class RBXAPI {

    public static void getRbxData(String uuid, Callback<RBXData> callback) {
        MiktoyaAPI.getRbxMySQL().get(uuid, callback);
    }
}
