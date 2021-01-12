package de.melonigemelone.miktoyaapi.api.coinssysteme.rtx;

import de.melonigemelone.miktoyaapi.MiktoyaAPI;

public class RBXData {

    private String uuid;
    private double rbx;


    public RBXData(String uuid, double rbx) {
        this.uuid = uuid;
        this.rbx = rbx;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public double getRbx() {
        return rbx;
    }

    public boolean hasRbx(double rbx) {
        return this.rbx >= rbx;
    }

    public void setRbx(double rbx) {
        this.rbx = rbx;
        update();
    }

    public void addRbx(double rbx) {
        this.rbx = this.rbx + rbx;
        update();
    }

    public void removeRbx(double rbx) {
        this.rbx = this.rbx - rbx;
        update();
    }

    public void update() {
        MiktoyaAPI.getRbxMySQL().update(this);
    }
}
