package de.melonigemelone.miktoyaapi.api.coinssysteme.rtx;

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
    public boolean existsPlayer(String uuid) {
        return existsData("rbx",
                "uuid  = '" + uuid + "'");

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
    public RBXData get(String uuid) {

        List<Object> results = get("rrbxtx",
                "uuid = '" + uuid + "'",
                new String[]{"rbx"});

        double rbx = Double.parseDouble(results.get(0).toString());

        return new RBXData(uuid, rbx);
    }
}
