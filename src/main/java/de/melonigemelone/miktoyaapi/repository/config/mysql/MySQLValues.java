package de.melonigemelone.miktoyaapi.repository.config.mysql;


/**
 * The MySQLValues for the DataBase Connection
 *
 * @author  MelonigeMelone
 * @version 1.0
 * @since   2020-12-22
 */

public enum MySQLValues {
    HOST("HOST", "localhost"),
    PORT("PORT", "3306"),
    DATABASE("DATABASE", "server"),
    USER("USER", "root"),
    PASSWORD("PASSWORD", "")
    ;

    String path;
    String value;

    MySQLValues(String path, String value) {
        this.path = path;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
       this.value = value;
    }

    public String getPath() {
        return path;
    }

}
