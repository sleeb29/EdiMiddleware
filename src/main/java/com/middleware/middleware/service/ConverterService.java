package com.middleware.middleware.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.middleware.middleware.converter.StringToEDIConverter;
import com.middleware.middleware.model.Connector;
import com.middleware.middleware.model.Instance;
import com.middleware.middleware.model.Middleware;
import com.middleware.middleware.model.edi.po.EDI850;
import com.middleware.middleware.processor.X12Processor;
import com.middleware.middleware.script.EvalConversionScript;
import generated.PostPurchaseOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.script.ScriptException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

@Service
public class ConverterService {

    @Autowired
    Middleware middleware;

    @Autowired
    Map<String, Connector> connectorMap;

    @Autowired
    StringToEDIConverter ediConverter;

    static final Logger LOGGER = Logger.getLogger(ConverterService.class);

    public EDI850 convertToEDI850(String purchaseOrderMessage)
            throws NoSuchFieldException, IllegalAccessException, JsonProcessingException
    {

        EDI850 edi850 = ediConverter.convertToEDI850Object(purchaseOrderMessage);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String xml = xmlMapper.writeValueAsString(edi850);
        LOGGER.info(xml);

        X12Processor processor = new X12Processor();
        EDI850 response = processor.process(edi850);

        sendEmail(edi850);

        return response;
    }

    public String convertMessage(String connectorId, String listeningPath, String message) throws ScriptException {

        Connector connector;

        if(!connectorMap.containsKey(connectorId)){
            connector = getConnector(connectorId);
            connectorMap.put(connectorId, connector);
        } else {
            connector = connectorMap.get(connectorId);
        }

        if(connector == null){
            return null;
        }

        if(!connector.getListeningPathToInstanceMap().containsKey(listeningPath)){
            return null;
        }

        Instance instance = connector.getListeningPathToInstanceMap().get(listeningPath);

        if(listeningPath.contains("ediToSoap")){

            String result = "";//sendEdiOnSOAPPath();
            return result;

        } else {
            EvalConversionScript evalConversionScript = new EvalConversionScript();
            String newMessage = evalConversionScript.convertMessage(connector.getScript(), message);

            String result = invokeDestinationService(instance.getDestinationEndpoint(), newMessage);
            return result;
        }

    }

    private Connector getConnector(String connectorId){

        List<Connector> connectorList = middleware.getConnectors();

        for(Connector connector : connectorList){
            if(connector.getName().equals(connectorId)){
                return connector;
            }
        }

        return null;

    }

    private String invokeDestinationService(String url, String message){
        return "";
    }

    private void sendEmail(EDI850 edi850)
    {
        String recipient = "sleeb@emich.edu";
        String sender = "edi850middleware@gmail.com";
        String host = "smtp.gmail.com";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", "25");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sender, System.getenv("MIDDLEWARE"));
            }
        });

        try
        {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));


            message.setSubject("Purchase Order: " + edi850.getST().getTransactionSetIdentifierCode());
            message.setText("Order fulfilled:\n");
            /*
            ITEM SUMMARY
             */
            Transport.send(message);
        }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        }
    }
}
