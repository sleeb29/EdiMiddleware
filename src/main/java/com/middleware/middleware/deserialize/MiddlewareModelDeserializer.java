package com.middleware.middleware.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.middleware.middleware.model.Connector;
import com.middleware.middleware.model.ConnectorInstance;
import com.middleware.middleware.model.Middleware;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        List<Connector> connectors = getConnectors(rootNode.get("Connectors"));
        List<ConnectorInstance> connectorInstances = getConnectorInstances(rootNode.get("ConnectorInstances"));

        middleware.setConnectors(connectors);
        middleware.setConnectorInstances(connectorInstances);

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

            connectors.add(connector);

        }

        return connectors;

    }

    private List<ConnectorInstance> getConnectorInstances(TreeNode connectorInstancesNode){

        List<ConnectorInstance> connectorInstances = new ArrayList<>();
        for(int i = 0; i < connectorInstancesNode.size(); i++){

            TreeNode connectorInstanceNode = connectorInstancesNode.get(i);
            ConnectorInstance connectorInstance = new ConnectorInstance();

            connectorInstance.setName(formatTreeNodeToString(connectorInstanceNode.get("name")));
            connectorInstance.
                    setDestinationEndpoint(formatTreeNodeToString(connectorInstanceNode.get("destination_endpoint")));
            connectorInstance.
                    setListeningEndpoint(formatTreeNodeToString(connectorInstanceNode.get("listening_endpoint")));

            connectorInstances.add(connectorInstance);

        }

        return connectorInstances;

    }

    private String formatTreeNodeToString(TreeNode sourceString) {
        return sourceString.toString().replace("\"", "");
    }

}
