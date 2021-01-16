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

    public CoinsData setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public double getCoins() {
        return coins;
    }

    public boolean hasCoins(double coins) {
      return this.coins >= coins;
    }

    public CoinsData setCoins(double coins) {
        this.coins = coins;
        update();
        return this;
    }

    public CoinsData addCoins(double coins) {
        this.coins = this.coins + coins;
        update();
        return this;
    }

    public CoinsData removeCoins(double coins) {
        this.coins = this.coins - coins;
        update();
        return this;
    }

    public CoinsData update() {
        MiktoyaAPI.getCoinsMySQL().update(this);
        return this;
    }
}
