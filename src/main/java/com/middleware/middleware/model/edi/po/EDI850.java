package com.middleware.middleware.model.edi.po;

import com.middleware.middleware.model.edi.EDI;

public class EDI850 extends EDI{

    PO_ST ST;

    public PO_ST getST() {
        return ST;
    }

    public void setST(PO_ST ST) {
        this.ST = ST;
    }
}
