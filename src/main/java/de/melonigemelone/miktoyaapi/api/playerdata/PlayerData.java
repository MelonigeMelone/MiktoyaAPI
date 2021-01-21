package de.melonigemelone.miktoyaapi.api.playerdata;


import de.melonigemelone.miktoyaapi.MiktoyaAPI;
import de.melonigemelone.miktoyaapi.api.languagesystem.Language;
import org.bukkit.entity.Player;

public class PlayerData {

    private String uuid;
    private String name;
    private Player player;
    private String ip;
    private String currentServerName;

    private Language language;
    private boolean selectedLanguage;
    private boolean vanish;

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

    public PlayerData setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlayerData setName(String name) {
        this.name = name;
        return this;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Language getLanguage() {
        return language;
    }

    public PlayerData setLanguage(Language language) {
        this.language = language;
        return this;
    }

    public boolean isCurrentlyOnline() {
        return currentlyOnline;
    }

    public PlayerData setCurrentlyOnline(boolean currentlyOnline) {
        this.currentlyOnline = currentlyOnline;
        return this;
    }

    public long getFirstJoin() {
        return firstJoin;
    }

    public PlayerData setFirstJoin(long firstJoin) {
        this.firstJoin = firstJoin;
        return this;
    }

    public long getLastTimeJoined() {
        return lastTimeJoined;
    }

    public PlayerData setLastTimeJoined(long lastTimeJoined) {
        this.lastTimeJoined = lastTimeJoined;
        return this;
    }

    public long getLastTimeOnline() {
        return lastTimeOnline;
    }

    public PlayerData setLastTimeOnline(long lastTimeOnline) {
        this.lastTimeOnline = lastTimeOnline;
        return this;
    }

    public long getOnlineTime() {
        return onlineTime;
    }

    public PlayerData setOnlineTime(long onlineTime) {
        this.onlineTime = onlineTime;
        return this;
    }

    public PlayerData setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public String getIp() {
        return ip;
    }

    public PlayerData setCurrentServerName(String currentServerName) {
        this.currentServerName = currentServerName;
        return this;
    }

    public String getCurrentServerName() {
        return currentServerName;
    }

    public PlayerData setVanish(boolean vanish) {
        this.vanish = vanish;
        MiktoyaAPI.getPlayerDataMySQL().updateVanish(this);
        return this;
    }

    public boolean isVanish() {
        return vanish;
    }

    public boolean isSelectedLanguage() {
        return selectedLanguage;
    }

    public PlayerData setSelectedLanguage(boolean selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
        MiktoyaAPI.getPlayerDataMySQL().updateSelectedLanguage(this);
        return this;
    }
}
