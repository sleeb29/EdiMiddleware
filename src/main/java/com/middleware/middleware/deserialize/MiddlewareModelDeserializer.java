package com.middleware.middleware.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.middleware.middleware.model.Connector;
import com.middleware.middleware.model.Instance;
import com.middleware.middleware.model.Middleware;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiddlewareModelDeserializer extends StdDeserializer<Middleware> {

    public MiddlewareModelDeserializer(){
        this(null);
    }

    public MiddlewareModelDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Middleware deserialize(JsonParser jsonParser, DeserializationContext context) throws IOException {

        Middleware middleware = new Middleware();
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        TreeNode rootNode = node.get("Middleware");
        middleware.setConnectors(getConnectors(rootNode.get("Connectors")));

        return middleware;

    }

    private List<Connector> getConnectors(TreeNode connectorsNode){

        List<Connector> connectors = new ArrayList<>();
        for(int i = 0; i < connectorsNode.size(); i++){

            TreeNode connectorNode = connectorsNode.get(i);
            Connector connector = new Connector();

            connector.setName(formatTreeNodeToString(connectorNode.get("name")));
            connector.setProtocol(formatTreeNodeToString(connectorNode.get("protocol")));
            connector.setScript(formatTreeNodeToString(connectorNode.get("script")));
            connector.setListeningPathToInstanceMap(getListeningPathToInstanceMap(connectorNode));

            connectors.add(connector);

        }

        return connectors;

    }

    private Map<String, Instance> getListeningPathToInstanceMap(TreeNode instancesNode){

        Map<String, Instance> listeningPathToInstanceMap = new HashMap<>();


        TreeNode instances = instancesNode.get("Instances");

        if(instances == null){
            return listeningPathToInstanceMap;
        }

        instances.fieldNames().forEachRemaining(instanceKey -> {

            TreeNode instanceNode = instances.get(instanceKey);
            Instance instance = new Instance();
            instance.setDestinationEndpoint(formatTreeNodeToString(instanceNode.get("destination_endpoint")));

            listeningPathToInstanceMap.put(instanceKey, instance);

        });

        return listeningPathToInstanceMap;

    }

    private String formatTreeNodeToString(TreeNode sourceString) {
        return sourceString.toString().replace("\"", "");
    }

}
