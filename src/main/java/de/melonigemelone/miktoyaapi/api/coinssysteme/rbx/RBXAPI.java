package de.melonigemelone.miktoyaapi.api.coinssysteme.rbx;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.repository.lib.database.mysql.Callback;

import java.util.HashMap;

public class RBXAPI {

    public static void getRbxData(String uuid, Callback<RBXData> callback) {
        MiktoyaAPI.getRbxMySQL().get(uuid, callback);
    }

    public static RBXData getRbxDataSync(String uuid) {
        return MiktoyaAPI.getRbxMySQL().getSync(uuid);
    }

    public static HashMap<String, RBXData> rbxDataHashMap = new HashMap<>();

    public static void loadRBXDataFromDataBase(String uuid) {
        MiktoyaAPI.getRbxMySQL().get(uuid, rbxData -> {
            rbxDataHashMap.put(uuid, rbxData);
        });
    }

    public static void removeRBXDataFromLocalStorgae(String uuid) {
        rbxDataHashMap.remove(uuid);
    }

    public static RBXData getCRBXDataFromOnlinePlayer(String uuid) {
        return rbxDataHashMap.get(uuid);
    }

    public static void getRBXDataFromOfflinePlayer(String uuid, Callback<RBXData> callback) {
        MiktoyaAPI.getRbxMySQL().get(uuid, callback);
    }

    public static RBXData getRBXDataFromOfflinePlayerSync(String uuid) {
        return MiktoyaAPI.getRbxMySQL().getSync(uuid);
    }
}
