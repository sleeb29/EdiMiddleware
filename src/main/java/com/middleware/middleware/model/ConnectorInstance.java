package com.middleware.middleware.model;

public class ConnectorInstance {


    String destinationEndpoint;
    String listeningEndpoint;
    String name;

    public String getDestinationEndpoint() {
        return destinationEndpoint;
    }

    public void setDestinationEndpoint(String destinationEndpoint) {
        this.destinationEndpoint = destinationEndpoint;
    }

    public String getListeningEndpoint() {
        return listeningEndpoint;
    }

    public void setListeningEndpoint(String listeningEndpoint) {
        this.listeningEndpoint = listeningEndpoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
