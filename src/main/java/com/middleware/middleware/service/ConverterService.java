package com.middleware.middleware.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.middleware.middleware.converter.EDIConverter;
import com.middleware.middleware.model.*;
import com.middleware.middleware.model.edi.po.BEG;
import com.middleware.middleware.model.edi.po.EDI850;
import com.middleware.middleware.processor.X12Processor;
import com.middleware.middleware.repository.EDIMessageRepository;
import com.middleware.middleware.repository.EDIMessageResponseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

import org.apache.log4j.Logger;

@Service
public class ConverterService {

    @Autowired
    EDIConverter ediConverter;

    @Autowired
    EDIMessageRepository ediMessageRepository;

    @Autowired
    EDIMessageResponseRepository ediMessageResponseRepository;

    static final Logger LOGGER = Logger.getLogger(ConverterService.class);

    public void convertToEDI850(String purchaseOrderMessage)
            throws NoSuchFieldException, IllegalAccessException, JsonProcessingException
    {
        EDI850 edi850 = ediConverter.convertToEDI850Object(purchaseOrderMessage);
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String xml = xmlMapper.writeValueAsString(edi850);
        LOGGER.info("\n\nREQUEST\n\n");
        LOGGER.info(xml);
        EDIMessage message = new EDIMessage();
        message.setSystemTime(System.currentTimeMillis());
        message.setProcessed(false);
        message.setMessage(xml);
        ediMessageRepository.save(message);

        X12Processor processor = new X12Processor();
        EDI850 response = processor.process(edi850);
        String xml2 = xmlMapper.writeValueAsString(response);
        LOGGER.info("\n\nSAMPLE RESPONSE\n\n");
        LOGGER.info(xml2);

        String x12Response = ediConverter.convertToX12(edi850);
        LOGGER.info("\n\nX12 Response\n\n");
        LOGGER.info(x12Response);
    }

    public String getX12Response() throws IOException, IllegalAccessException {
        EDIMessageResponse response = ediMessageResponseRepository
                .findAll()
                .stream()
                .filter(inner -> !inner.isProcessed())
                .sorted(Comparator.comparing(inner -> inner.getSystemTime()))
                .findFirst()
                .orElse(null);

        if(response == null)
        {
            return "";
        }
        XmlMapper xmlMapper = new XmlMapper();
        EDI850 edi850 = xmlMapper.readValue(new StringReader(response.getMessage()), EDI850.class);
        response.setProcessed(true);
        ediMessageResponseRepository.save(response);
        String x12Response = ediConverter.convertToX12(edi850);
        return x12Response;
    }

    public List<EDI850> processPurchaseOrders() throws JsonProcessingException {
        List<EDIMessage> messages = ediMessageRepository.findAll();
        List<EDI850> unprocessedMessages = new ArrayList<>();
        messages.forEach(message ->
        {
            if (!message.isProcessed()) {
                EDI850 edi850 = null;
                XmlMapper xmlMapper = new XmlMapper();
                try {
                    edi850 = xmlMapper.readValue(new StringReader(message.getMessage()), EDI850.class);
                    unprocessedMessages.add(edi850);
                    message.setProcessed(true);
                    ediMessageRepository.save(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String xml = xmlMapper.writeValueAsString(unprocessedMessages);
        LOGGER.info("UNPROCESSED XML");
        LOGGER.info(xml);
        return unprocessedMessages;
    }

    public void sendProcessedPurchaseOrder(EDI850 edi850) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String xml = xmlMapper.writeValueAsString(edi850);
        LOGGER.info("\n\nPURCHASE ORDER RESPONSE\n\n");
        LOGGER.info(xml);
        EDIMessageResponse response = new EDIMessageResponse();
        response.setSystemTime(System.currentTimeMillis());
        response.setProcessed(false);
        response.setMessage(xml);
        ediMessageResponseRepository.save(response);
        sendEmail(edi850);
    }

    public void sendEmail(EDI850 edi850)
    {
        String recipient = System.getenv("MIDDLEWARE_RECIPIENT");//"sleeb@emich.edu";
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

            StringBuilder messageText = new StringBuilder("Order fulfilled:\n");
            BEG beg = edi850.getST().getBEG();
            String dateText = beg.getDTM().getSystemDate() + "T" + beg.getDTM().getSystemTime();
            messageText.append("fulfilled date: " + dateText + "\n");
            messageText.append("Instructions " + beg.getMSG().getMessages().get(0) + "\n");
            messageText.append("Reference Number to look up order:" + beg.getPurchaseOrderNumber());
            message.setText(messageText.toString());
            Transport.send(message);
        }
        catch (MessagingException mex)
        {
            mex.printStackTrace();
        }
    }
}
