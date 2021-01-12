package de.melonigemelone.miktoyaapi.api.coinssysteme.rtx;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;

public class RBXAPI {

    public static RBXData getRbxData(String uuid) {
        return MiktoyaAPI.getRbxMySQL().get(uuid);
    }
}
