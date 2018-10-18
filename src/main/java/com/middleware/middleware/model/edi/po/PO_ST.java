package com.middleware.middleware.model.edi.po;

import com.middleware.middleware.model.edi.ST;

public class PO_ST extends ST {

    BEG BEG;
    CTT CTT;

    public BEG getBEG() {
        return BEG;
    }

    public void setBEG(BEG BEG) {
        this.BEG = BEG;
    }

    public CTT getCTT() {
        return CTT;
    }

    public void setCTT(CTT CTT) {
        this.CTT = CTT;
    }
}
