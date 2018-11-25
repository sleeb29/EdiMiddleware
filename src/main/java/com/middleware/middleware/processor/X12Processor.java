package com.middleware.middleware.processor;

import com.middleware.middleware.model.edi.po.*;

import java.util.ArrayList;
import java.util.List;

public class X12Processor {
    public EDI850 process(EDI850 incoming)
    {
        EDI850 outgoing = new EDI850();
        PO_ST st = new PO_ST();
        st.setTransactionSetIdentifierCode(incoming.getST().getTransactionSetIdentifierCode());
        st.setTransactionSetControlNumber(incoming.getST().getTransactionSetControlNumber());
        outgoing.setST(st);

        BEG outgoingBeg = new BEG();
        BEG incomingBeg = incoming.getST().getBEG();
        outgoing.getST().setBEG(outgoingBeg);
        outgoingBeg.setTransactionSetPurchaseCode(incomingBeg.getTransactionSetPurchaseCode());
        outgoingBeg.setReleaseNumber(incomingBeg.getReleaseNumber());
        outgoingBeg.setPurchaseOrderNumber(incomingBeg.getReleaseNumber());
        outgoingBeg.setContractNumber(incomingBeg.getContractNumber());

        outgoingBeg.setN9(incomingBeg.getN9());
        outgoingBeg.setDTM(incomingBeg.getDTM());

        MSG msg = new MSG();
        msg.setMessage("Fulfilling order.");
        List<MSG> msgList = new ArrayList<>();
        msgList.add(msg);
        outgoingBeg.setMSG2(msgList);

        EXT_MSG extMsg = new EXT_MSG();
        outgoingBeg.setMSG(extMsg);
        extMsg.setMessages(incomingBeg.getMSG().getMessages());
        N1 n1 = new N1();
        n1.setNameOfBuyingParty("BUYING PARTY");
        n1.setEntityIdCode("VN");
        n1.setIdCodeQualifier("91");
        n1.setIdCode("1VN");
        List<N1> n1List = new ArrayList<>();
        n1List.add(n1);
        extMsg.setN1(n1List);

        PER per = new PER();
        per.setTelephoneNumber("7340013303");
        per.setCommunicationNumberQualifier("EM");
        per.setName("Harry Smith");
        per.setContractFunctionCode("ZZ");

        List<PER> pers = new ArrayList<>();
        pers.add(per);
        extMsg.setPER(pers);

        outgoingBeg.setPO(incomingBeg.getPO());
        outgoing.getST().setCTT(incoming.getST().getCTT());

        outgoing.setSE(incoming.getSE());
        outgoing.setGS(incoming.getGS());
        outgoing.setGE(incoming.getGE());
        outgoing.setIEA(incoming.getIEA());
        outgoing.setISA(incoming.getISA());

        return outgoing;
    }
}
