package com.middleware.middleware.model.edi;

public abstract class EDI {

    ISA ISA;
    GS GS;
    SE SE;
    GE GE;
    IEA IEA;

    public ISA getISA() {
        return ISA;
    }

    public void setISA(ISA ISA) {
        this.ISA = ISA;
    }

    public GS getGS() {
        return GS;
    }

    public void setGS(GS GS) {
        this.GS = GS;
    }

    public SE getSE() {
        return SE;
    }

    public void setSE(SE SE) {
        this.SE = SE;
    }

    public GE getGE() {
        return GE;
    }

    public void setGE(GE GE) {
        this.GE = GE;
    }

    public IEA getIEA() {
        return IEA;
    }

    public void setIEA(IEA IEA) {
        this.IEA = IEA;
    }
}
