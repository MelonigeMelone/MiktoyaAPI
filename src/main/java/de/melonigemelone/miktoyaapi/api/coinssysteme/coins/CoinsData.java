package de.melonigemelone.miktoyaapi.api.coinssysteme.coins;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;

public class CoinsData {

    private String uuid;
    private double coins;


    public CoinsData(String uuid, double coins) {
        this.uuid = uuid;
        this.coins = coins;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public double getCoins() {
        return coins;
    }

    public boolean hasCoins(double coins) {
      return this.coins >= coins;
    }

    public void setCoins(double coins) {
        this.coins = coins;
        update();
    }

    public void addCoins(double coins) {
        this.coins = this.coins + coins;
        update();
    }

    public void removeCoins(double coins) {
        this.coins = this.coins - coins;
        update();
    }

    public void update() {
        MiktoyaAPI.getCoinsMySQL().update(this);
    }
}
