package de.melonigemelone.miktoyaapi.api.coinssysteme.economy;

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

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public double getMoney() {
        return money;
    }

    public boolean hasMoney(double money) {
        return this.money >= money;
    }

    public void setMoney(double money) {
        this.money = money;
        update();
    }

    public void addMoney(double money) {
        this.money = this.money + money;
        update();
    }

    public void removeMoney(double money) {
        this.money = this.money - money;
        update();
    }

    public void update() {

    }
}
