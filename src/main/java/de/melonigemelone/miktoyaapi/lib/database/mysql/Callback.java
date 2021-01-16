package de.melonigemelone.miktoyaapi.lib.database.mysql;

public interface Callback<T> {
    void taskDone(T t);
}
