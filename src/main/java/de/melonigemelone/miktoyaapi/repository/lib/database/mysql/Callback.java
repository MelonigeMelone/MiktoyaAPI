package de.melonigemelone.miktoyaapi.repository.lib.database.mysql;

public interface Callback<T> {
    void taskDone(T t);
}
