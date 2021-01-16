package de.melonigemelone.miktoyaapi.api.coinssysteme.economy;

import de.melonigemelone.miktoyaapi.api.coinssysteme.coins.CoinsData;
import de.melonigemelone.miktoyaapi.lib.database.mysql.Callback;
import de.melonigemelone.miktoyaapi.lib.database.mysql.MySQL;
import de.melonigemelone.miktoyaapi.mysql.MySQLValues;

import java.util.List;

public class EconomyMySQL extends MySQL {

    //Connect with Database and create tables
    public EconomyMySQL() {
        super(MySQLValues.HOST.getValue(), MySQLValues.PORT.getValue(), MySQLValues.DATABASE.getValue(), MySQLValues.USER.getValue(), MySQLValues.PASSWORD.getValue());

        createTableIfNotExists("economy",
                "  `id` int(11) unsigned NOT NULL AUTO_INCREMENT," +
                        "  `uuid` varchar(64) NOT NULL DEFAULT ''," +
                        "  `money` double NOT NULL DEFAULT '0'," +
                        "  PRIMARY KEY (`id`)"
        );
    }

    //Check if Player exists in DB
    public boolean existsPlayer(String uuid) {
        return existsDataSync("economy",
                "uuid  = '" + uuid + "'");

    }

    //Create new Player in DB
    public void createPlayer(String uuid) {
        insertData("economy",
                "uuid, money",
                "'" + uuid + "', 0");

    }


    //Update CoinsData
    public void update(EconomyData economyData) {
        update("economy",
                "money = " + economyData.getMoney() + "",
                "uuid = '" + economyData.getUuid() + "'");
    }

    //Get CoinsData
    public EconomyData get(String uuid) {

        List<Object> result = getSync("economy",
                "uuid = '" + uuid + "'",
                new String[]{"money"});

        double money = Double.parseDouble(result.get(0).toString());

        return new EconomyData(uuid, money);


    }
}
