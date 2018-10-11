package com.middleware.middleware.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

import com.middleware.middleware.deserialize.MiddlewareModelDeserializer;

@JsonDeserialize(using = MiddlewareModelDeserializer.class)
public class Middleware {

    List<Connector> connectors;

    public List<Connector> getConnectors() {
        return connectors;
    }

    public void setConnectors(List<Connector> connectors) {
        this.connectors = connectors;
    }


}
