package de.melonigemelone.miktoyaapi.mysql;


import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.lib.configuration.yaml.YamlFileBuilder;


public class MySQLConfigHandler extends YamlFileBuilder {

    public MySQLConfigHandler() {
        super(MiktoyaAPI.getInstance().getDataFolder().getPath(), "mysql.yml");
        load();
    }

    public void load() {

        for(MySQLValues value : MySQLValues.values()) {
            setIfNotExists(value.getPath(), value.getValue());
        }

        save();

        //Load Values
        for(MySQLValues value : MySQLValues.values()) {
            value.setValue(getString(value.getPath()));
        }
    }

}
