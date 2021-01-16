package de.melonigemelone.miktoyaapi.api.coinssysteme.rbx;

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

    public RBXData setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public double getRbx() {
        return rbx;
    }

    public boolean hasRbx(double rbx) {
        return this.rbx >= rbx;
    }

    public RBXData setRbx(double rbx) {
        this.rbx = rbx;
        update();
        return this;
    }

    public RBXData addRbx(double rbx) {
        this.rbx = this.rbx + rbx;
        update();
        return this;
    }

    public RBXData removeRbx(double rbx) {
        this.rbx = this.rbx - rbx;
        update();
        return this;
    }

    public RBXData update() {
        MiktoyaAPI.getRbxMySQL().update(this);
        return this;
    }
}
