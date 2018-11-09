package com.middleware.middleware.service;

import com.middleware.middleware.model.Connector;
import com.middleware.middleware.model.Instance;
import com.middleware.middleware.model.Middleware;
import com.middleware.middleware.script.EvalConversionScript;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.script.ScriptException;
import java.util.List;
import java.util.Map;

@Service
public class ConverterService {

    @Autowired
    Middleware middleware;

    @Autowired
    Map<String, Connector> connectorMap;

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

}
