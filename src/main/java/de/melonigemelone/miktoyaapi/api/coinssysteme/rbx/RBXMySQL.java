package de.melonigemelone.miktoyaapi.api.coinssysteme.rbx;

import de.melonigemelone.miktoyaapi.lib.database.mysql.Callback;
import de.melonigemelone.miktoyaapi.lib.database.mysql.MySQL;
import de.melonigemelone.miktoyaapi.mysql.MySQLValues;

import java.util.List;

public class RBXMySQL extends MySQL {

    //Connect with Database and create tables
    public RBXMySQL() {
        super(MySQLValues.HOST.getValue(), MySQLValues.PORT.getValue(), MySQLValues.DATABASE.getValue(), MySQLValues.USER.getValue(), MySQLValues.PASSWORD.getValue());

        createTableIfNotExists("rbx",
                "  `id` int(11) unsigned NOT NULL AUTO_INCREMENT," +
                        "  `uuid` varchar(64) NOT NULL DEFAULT ''," +
                        "  `rbx` double NOT NULL DEFAULT '0'," +
                        "  PRIMARY KEY (`id`)"
        );
    }

    //Check if Player exists in DB
    public void existsPlayer(String uuid, Callback<Boolean> callback) {
        existsData("rbx",
                "uuid  = '" + uuid + "'", callback);

    }

    //Create new Player in DB
    public void createPlayer(String uuid) {
        insertData("rbx",
                "uuid, rbx",
                "'" + uuid + "', 0");

    }


    //Update CoinsData
    public void update(RBXData rbxData) {
        update("rbx",
                "rbx = " + rbxData.getRbx() + "",
                "uuid = '" + rbxData.getUuid() + "'");
    }

    //Get CoinsData
    public void get(String uuid, Callback<RBXData> callback) {

        get("rrbxtx",
                "uuid = '" + uuid + "'",
                new String[]{"rbx"}, result -> {

                    double rbx = Double.parseDouble(result.get(0).toString());

                    callback.taskDone(new RBXData(uuid, rbx));
                });

    }
}
