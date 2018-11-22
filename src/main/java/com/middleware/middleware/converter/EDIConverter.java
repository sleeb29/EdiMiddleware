package com.middleware.middleware.converter;

import com.middleware.middleware.model.edi.*;
import com.middleware.middleware.model.edi.po.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Component
public class EDIConverter {

    static final String DELIMITER = "[*]";

    public EDI850 convertToEDI850Object(String message) throws NoSuchFieldException, IllegalAccessException {

        EDI850 edi850 = new EDI850();
        String[] lines = message.split("\n");

        ISA isa = new ISA();
        GS gs = new GS();
        PO_ST st = new PO_ST();

        edi850.setISA(isa);
        edi850.setGS(gs);
        edi850.setST(st);

        String[] ISALine = lines[0].split(DELIMITER);
        setFields(isa, "ISA", ISALine);
        String[] GSLine = lines[1].split(DELIMITER);
        setFields(gs, "GS", GSLine);

        String[] STLine = lines[2].split(DELIMITER);
        st.setTransactionSetControlNumber(STLine[0]);
        st.setTransactionSetIdentifierCode(STLine[1]);

        BEG beg = new BEG();
        st.setBEG(beg);

        String[] BEGLine = lines[3].split(DELIMITER);
        switch (BEGLine.length) {
            case 7:
                beg.setContractNumber(BEGLine[6]);
            case 6:
                beg.setPurchaseOrderDate(BEGLine[5]);
            case 5:
                beg.setReleaseNumber(BEGLine[4]);
            case 4:
                beg.setPurchaseOrderNumber(BEGLine[3]);
            case 3:
                beg.setPurchaseOrderTypeCode(BEGLine[2]);
            case 2:
                beg.setTransactionSetPurchaseCode(BEGLine[1]);
        }

        String[] N9Line = lines[4].split(DELIMITER);
        N9 n9 = new N9();
        beg.setN9(n9);

        switch(N9Line.length) {
            case 3: n9.setReferenceIdentification(N9Line[2]);
            case 2: n9.setReferenceIdentificationQualifier(N9Line[1]);
        }

        String[] DTMLine = lines[5].split(DELIMITER);
        DTM dtm = new DTM();
        beg.setDTM(dtm);

        switch(DTMLine.length) {
            case 4: dtm.setSystemTime(DTMLine[3]);
            case 3: dtm.setSystemDate(DTMLine[2]);
            case 2: dtm.setDateTimeQualifier(DTMLine[1]);
        }

        EXT_MSG extMsg = new EXT_MSG();
        beg.setMSG(extMsg);
        int pointer = 6;
        List<MSG> msgList = new ArrayList<>();
        extMsg.setMessages(msgList);
        for(int i = pointer; i < lines.length; i++) {
            String next = lines[i];
            if (!next.startsWith("MSG")) {
                break;
            }

            pointer++;

            MSG msg = new MSG();
            msgList.add(msg);
            msg.setMessage(lines[i].split(DELIMITER)[1]);
        }

        List<N1> n1List = new ArrayList<>();
        extMsg.setN1(n1List);
        for(int i = pointer; i < lines.length; i++)
        {
            String next = lines[i];
            if(!next.startsWith("N1"))
            {
                break;
            }

            pointer++;

            String[] n1Line = lines[i].split(DELIMITER);
            N1 n1 = new N1();
            n1List.add(n1);

            switch(n1Line.length) {
                case 5: n1.setIdCode(n1Line[4]);
                case 4: n1.setIdCodeQualifier(n1Line[3]);
                case 3: n1.setNameOfBuyingParty(n1Line[2]);
                case 2: n1.setEntityIdCode(n1Line[1]);
            }
        }

        List<N3> n3List = new ArrayList<>();
        extMsg.setN3(n3List);
        for(int i = pointer; i < lines.length; i++)
        {
            String next = lines[i];
            if(!next.startsWith("N3"))
            {
                break;
            }

            pointer++;

            String[] n3Line = lines[i].split(DELIMITER);
            N3 n3 = new N3();
            n3List.add(n3);

            switch(n3Line.length) {
                case 3: n3.setStreetAddress2(n3Line[2]);
                case 2: n3.setStreetAddress1(n3Line[1]);
            }
        }

        List<N4> n4List = new ArrayList<>();
        extMsg.setN4(n4List);
        for(int i = pointer; i < lines.length; i++)
        {
            String next = lines[i];
            if(!next.startsWith("N4"))
            {
                break;
            }

            pointer++;

            String[] n4Line = lines[i].split(DELIMITER);
            N4 n4 = new N4();
            n4List.add(n4);

            switch(n4Line.length) {
                case 4: n4.setPostalCode(n4Line[3]);
                case 3: n4.setStateOrProvinceCode(n4Line[2]);
                case 2: n4.setCityName(n4Line[1]);
            }
        }

        List<PER> perList = new ArrayList<>();
        extMsg.setPER(perList);
        for(int i = pointer; i < lines.length; i++)
        {
            String next = lines[i];
            if(!next.startsWith("PER"))
            {
                break;
            }

            pointer++;

            String[] perLine = lines[i].split(DELIMITER);
            PER per = new PER();

            switch(perLine.length) {
                case 5: per.setTelephoneNumber(perLine[4]);
                case 4: per.setCommunicationNumberQualifier(perLine[3]);
                case 3: per.setName(perLine[2]);
                case 2: per.setContractFunctionCode(perLine[1]);
            }
        }

        List<PO> poList = new ArrayList<>();
        beg.setPO(poList);
        PO prev = null;
        for(int i = pointer; i < lines.length; i++)
        {
            String next = lines[i];
            if(next.startsWith("PO"))
            {
                String[] poLine = lines[i].split(DELIMITER);

                if(poLine.length >= 6) {
                    PO po = new PO();
                    po.setAssignedIdentifier(poLine[1]);
                    po.setQuantityOrdered(poLine[2]);
                    po.setUnitOfMeasure(poLine[3]);
                    po.setItemUnitPrice(poLine[4]);
                    po.setItemUnitPrice(poLine[5]);
                    prev = po;
                } else {
                    prev = null;
                }

            } else if(next.startsWith("PID")) {
                String[] pidLine = lines[i].split(DELIMITER);
                PID pid = new PID();

                switch(pidLine.length) {
                    case 3: pid.setDescription(pidLine[2]);
                    case 2: pid.setItemDescriptionType(pidLine[1]);
                }

                if(prev != null) prev.setPid(pid);
            } else {
                break;
            }

            pointer++;
        }

        List<REF> refList = new ArrayList<>();
        beg.setREF(refList);
        for(int i = pointer; i < lines.length; i++)
        {
            String next = lines[i];
            if(!next.startsWith("REF"))
            {
                break;
            }

            pointer++;

            String[] refLine = lines[i].split(DELIMITER);
            REF ref = new REF();

            switch(refLine.length) {
                case 4: ref.setDescription(refLine[3]);
                case 3: ref.setReferenceIdentification(refLine[2]);
                case 2: ref.setReferenceIdentificationQualifier(refLine[1]);
            }
        }

        pointer++;

        List<MSG> msg2 = new ArrayList<>();
        beg.setMSG2(msg2);
        for(int i = pointer; i < lines.length; i++)
        {
            String next = lines[i];
            if(!next.startsWith("MSG"))
            {
                break;
            }

            pointer++;

            MSG msg = new MSG();
            msg2.add(msg);
            msg.setMessage(lines[i].split(DELIMITER)[1]);
        }

        CTT ctt = new CTT();
        st.setCTT(ctt);
        String[] CTTLine = lines[pointer++].split(DELIMITER);
        ctt.setTotalNumberOfPurchaseOrderLineItems(CTTLine[1]);
        ctt.setHashTotal(CTTLine[2]);

        SE se = new SE();
        edi850.setSE(se);
        String[] SELine = lines[pointer++].split(DELIMITER);
        se.setNumberOfSegmenetsIncluded(SELine[1]);
        se.setTransactionSetControlNumber(SELine[2]);

        GE ge = new GE();
        edi850.setGE(ge);
        String[] GELine = lines[pointer++].split(DELIMITER);
        ge.setGE01(GELine[1]);
        ge.setGE02(GELine[2]);

        IEA iea = new IEA();
        edi850.setIEA(iea);
        String[] IEALine = lines[pointer++].split(DELIMITER);
        iea.setIEA01(IEALine[1]);
        iea.setIEA02(IEALine[2]);

        return edi850;

    }

    private String getFields(Object obj, String fieldName) throws IllegalAccessException {
        List<String> output = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for(Field field : fields)
        {
            if(field.getName().startsWith(fieldName))
            {
                field.setAccessible(true);
                output.add(field.get(obj).toString());
            }
        }
        return String.join("*", output);
    }

    private void setFields(Object obj, String fieldName, String[] record)
            throws NoSuchFieldException, IllegalAccessException {
        for(int i = 1; i < record.length; i++)
        {
            String numericString = getNumericString(i);
            Field isaField = obj.getClass().getDeclaredField(fieldName + numericString);
            isaField.setAccessible(true);
            isaField.set(obj, record[i]);
        }
    }

    private String getNumericString(int number){
        String temp = Integer.toString(number);
        if(temp.length() == 1)
        {
            return "0" + temp;
        }
        return temp;
    }

    public String convertToX12(EDI850 edi850)
            throws IllegalAccessException
    {
        String output = "*";
        StringBuilder x12 = new StringBuilder();
        x12.append("ISA" + output + getFields(edi850.getISA(), "ISA"));
        x12.append("GS" + output + getFields(edi850.getGS(), "GS"));
        String ST = "ST" + output + edi850.getST().getTransactionSetControlNumber() + output
                + edi850.getST().getTransactionSetIdentifierCode();
        x12.append(ST);
        BEG beg = edi850.getST().getBEG();
        String[] BEGValues = new String[]{"BEG",
                beg.getTransactionSetPurchaseCode(),
                beg.getPurchaseOrderTypeCode(),
                beg.getPurchaseOrderNumber(),
                beg.getReleaseNumber(),
                beg.getPurchaseOrderDate(),
                beg.getContractNumber()};
        x12.append(String.join(output, BEGValues));
        x12.append("N9" + output + beg.getN9().getReferenceIdentification() + output +
                   beg.getN9().getReferenceIdentificationQualifier());
        String[] DTMValues = new String[]{"DTM",
            beg.getDTM().getSystemDate(),
            beg.getDTM().getSystemTime(),
            beg.getDTM().getDateTimeQualifier()};
        x12.append(String.join(output, DTMValues));
        EXT_MSG msg = beg.getMSG();
        for(MSG child : msg.getMessages())
        {
            x12.append("MSG" + output + child.getMessage());
        }
        for(N1 n1 : msg.getN1())
        {
            x12.append("N1" + output + n1.getEntityIdCode() + output +
                        n1.getNameOfBuyingParty() + output + n1.getIdCodeQualifier() + output +
                        n1.getIdCode());
        }
        for(N3 n3 : msg.getN3())
        {
            x12.append("N3" + output + n3.getStreetAddress1() + output + n3.getStreetAddress2());
        }
        for(N4 n4 : msg.getN4())
        {
            x12.append("N4" + output + n4.getCityName() + output + n4.getStateOrProvinceCode() +
                    output + n4.getPostalCode());
        }
        for(PER per : msg.getPER())
        {
            x12.append("PER" + per.getCommunicationNumberQualifier() + output +
            per.getName() + output + per.getContractFunctionCode() + output +
            per.getTelephoneNumber());
        }
        for(PO po : beg.getPO())
        {
            String[] POLine = new String[]{
              "PO",
              po.getAssignedIdentifier(),
                    po.getQuantityOrdered(),
                    po.getUnitOfMeasure(),
                    po.getItemUnitPrice(),
                    po.getItemUnitPrice()
            };
            x12.append(String.join(output, POLine));
            String[] PIDLine = new String[]{
                    "PID",
                    po.getPid().getItemDescriptionType(),
                    po.getPid().getDescription()
            };
            x12.append(String.join(output, PIDLine));
        }
        for(REF ref : beg.getREF())
        {
            String[] refLine = new String[]{
                    "REF",
                    ref.getReferenceIdentificationQualifier(),
                    ref.getReferenceIdentification(),
                    ref.getDescription()
            };
            x12.append(String.join(output, refLine));
        }
        x12.append("SDQ*CS*57*1000*1");
        for(MSG simpleMessage : beg.getMSG2())
        {
            x12.append(String.join("MSG" + output + simpleMessage.getMessage()));
        }
        CTT ctt = edi850.getST().getCTT();
        x12.append("CTT" + output + ctt.getTotalNumberOfPurchaseOrderLineItems() +
                output + ctt.getHashTotal());
        SE se = edi850.getSE();
        x12.append("SE" + output + se.getNumberOfSegmenetsIncluded() + output +
        se.getTransactionSetControlNumber());
        GE ge = edi850.getGE();
        x12.append("GE" + output + ge.getGE01() + output + ge.getGE02());
        IEA iea = edi850.getIEA();
        x12.append("IEA" + output + iea.getIEA01() + output + iea.getIEA02());
        return x12.toString().replace("null", "");
    }

    static public void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        EDIConverter converter = new EDIConverter();
        String EDI = "ISA*00* *00* * ZZ*5489002 *01*197607336 *980710*154 9*U*00400*191154908*0*P*|\n" +
                "GS*PO*5489002*197607336*20000616*1549*191154909*X*004010\n" +
                "ST*850*191154910\n" +
                "BEG*00*SA*144**20000616\n" +
                "N9*PO*144\n" +
                "DTM*097*20000616*1549\n" +
                "MSG*PLEASE SHIP ASAP\n" +
                "MSG*NET 30 DAYS\n" +
                "N1*BY*GENERAL HOSPITAL*91*123456\n" +
                "N1*BT*GENERAL SUPPLIES*91*55123456\n" +
                "N1*ST*WEST PARK*91*77756\n" +
                "N3*1000 Pacer Drive*SUITE 400\n" +
                "N4*CHICAGO*IL*60020\n" +
                "PER*SR*BARRY WILSON*TE*8475374800\n" +
                "PO1*1*1*CS*0.01**IN*7237823*VC*7219D*SN*BRD951028817\n" +
                "PID*F****PCD 100ML VIALS\n" +
                "REF*CA*1000*1-WEST\n" +
                "SDQ*CS*57*1000*1\n" +
                "MSG*PLEASE SHIP THIS ITEM ASAP\n" +
                "MSG*SN:BRD8327495 BILL ONLY PT:SMITH,JOHN\n" +
                "CTT*1*1\n" +
                "SE*24*191154910\n" +
                "GE*1*191154909\n" +
                "IEA*1*191154908";
        converter.convertToEDI850Object(EDI);
    }
}
