package de.melonigemelone.miktoyaapi.api.playerdata;


import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.api.languagesystem.Language;

public class PlayerData {

    private String uuid;
    private String name;
    private String ip;
    private String currentServerName;

    private Language language;

    private boolean currentlyOnline;
    private long firstJoin;
    private long lastTimeJoined;
    private long lastTimeOnline;
    private long onlineTime;

    public PlayerData(String uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public boolean isCurrentlyOnline() {
        return currentlyOnline;
    }

    public void setCurrentlyOnline(boolean currentlyOnline) {
        this.currentlyOnline = currentlyOnline;
    }

    public long getFirstJoin() {
        return firstJoin;
    }

    public void setFirstJoin(long firstJoin) {
        this.firstJoin = firstJoin;
    }

    public long getLastTimeJoined() {
        return lastTimeJoined;
    }

    public void setLastTimeJoined(long lastTimeJoined) {
        this.lastTimeJoined = lastTimeJoined;
    }

    public long getLastTimeOnline() {
        return lastTimeOnline;
    }

    public void setLastTimeOnline(long lastTimeOnline) {
        this.lastTimeOnline = lastTimeOnline;
    }

    public long getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(long onlineTime) {
        this.onlineTime = onlineTime;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setCurrentServerName(String currentServerName) {
        this.currentServerName = currentServerName;
    }

    public String getCurrentServerName() {
        return currentServerName;
    }
}
