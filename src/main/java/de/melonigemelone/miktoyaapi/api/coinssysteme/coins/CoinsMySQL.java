package de.melonigemelone.miktoyaapi.api.coinssysteme.coins;

import de.melonigemelone.miktoyaapi.repository.config.mysql.MySQLValues;
import de.melonigemelone.miktoyaapi.repository.lib.database.mysql.Callback;
import de.melonigemelone.miktoyaapi.repository.lib.database.mysql.MySQL;

import java.util.List;

public class CoinsMySQL extends MySQL {

    //Connect with Database and create tables
    public CoinsMySQL() {
        super(MySQLValues.HOST.getValue(), MySQLValues.PORT.getValue(), MySQLValues.DATABASE.getValue(), MySQLValues.USER.getValue(), MySQLValues.PASSWORD.getValue());

        createTableIfNotExists("coins",
                "  `id` int(11) unsigned NOT NULL AUTO_INCREMENT," +
                        "  `uuid` varchar(64) NOT NULL DEFAULT ''," +
                        "  `coins` double NOT NULL DEFAULT '0'," +
                        "  PRIMARY KEY (`id`)"
        );
    }

    //Check if Player exists in DB
    public void existsPlayer(String uuid, Callback<Boolean> callback) {
        existsData("coins",
                "uuid  = '" + uuid + "'", callback);

    }

    //Create new Player in DB
    public void createPlayer(String uuid) {
        insertData("coins",
                "uuid, coins",
                "'" + uuid + "', 0");

    }


    //Update CoinsData
    public void update(CoinsData coinsData) {
        update("coins",
                "coins = " + coinsData.getCoins() + "",
                "uuid = '" + coinsData.getUuid() + "'");
    }

    //Get CoinsData
    public void get(String uuid, Callback<CoinsData> callback) {
        get("coins",
                "uuid = '" + uuid + "'",
                new String[]{"coins"}, result -> {

                    double coins = Double.parseDouble(result.get(0).toString());

                    callback.taskDone(new CoinsData(uuid, coins));
                });
    }

    //Get CoinsData
    public CoinsData getSync(String uuid) {
        List<Object> result =  getSync("coins",
                "uuid = '" + uuid + "'",
                new String[]{"coins"});

        double coins = Double.parseDouble(result.get(0).toString());

        return new CoinsData(uuid, coins);

    }


}


