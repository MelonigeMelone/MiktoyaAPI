package de.melonigemelone.miktoyaapi.api.coinssysteme.economy;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;

public class EconomyData {

    private String uuid;
    private double money;


    public EconomyData(String uuid, double money) {
        this.uuid = uuid;
        this.money = money;
    }

    public String getUuid() {
        return uuid;
    }

    public EconomyData setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public double getMoney() {
        return money;
    }

    public boolean hasMoney(double money) {
        return this.money >= money;
    }

    public EconomyData setMoney(double money) {
        this.money = money;
        update();
        return this;
    }

    public EconomyData addMoney(double money) {
        this.money = this.money + money;
        update();
        return this;
    }

    public EconomyData removeMoney(double money) {
        this.money = this.money - money;
        update();
        return this;
    }

    public EconomyData update() {
        MiktoyaAPI.getEconomyMySQL().update(this);
        return this;
    }
}
